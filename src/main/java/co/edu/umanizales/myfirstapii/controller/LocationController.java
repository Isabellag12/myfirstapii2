package co.edu.umanizales.myfirstapii.controller;

import co.edu.umanizales.myfirstapii.model.Location;
import co.edu.umanizales.myfirstapii.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path ="/Location")
public class LocationController {
    /*
        @GetMapping
        public String getlocation(){
            Location location = new Location("17001","Manizales");

            return "manizales";
        }
    */
    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Location> getLocations() {

        return locationService.getLocations();

    }

    @GetMapping(path = "/{code}")
    public Location getLocationByCode(@PathVariable String code){
        return locationService.getLocationByCode(code);
    }

    @GetMapping(path = "/states")
    public List<Location> getLocationsByStates(){
        return locationService.getStates();
    }

    @GetMapping(path = "/name/{name}")
    public Location getLocationByName(@PathVariable String name){return locationService.getLocationByName(name);}

    @GetMapping(path = "/initialLetter/{initialLetter}")
    public List<Location> getLocationByInitialLetter (@PathVariable String initialLetter){ return locationService.getLocationByInitialLetter(initialLetter);}

    @GetMapping("/byMinLength/{minLength}")
    public List<Location> getLocationsByMinLength(@PathVariable int minLength) {
        return locationService.getLocationsByMinNameLength(minLength);
    }


}
