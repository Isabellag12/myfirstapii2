package co.edu.umanizales.myfirstapii.controller;

import co.edu.umanizales.myfirstapii.controller.dto.RequestStoreDTO;
import co.edu.umanizales.myfirstapii.model.Location;
import co.edu.umanizales.myfirstapii.model.Store;
import co.edu.umanizales.myfirstapii.service.LocationService;
import co.edu.umanizales.myfirstapii.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/store" )
public class StoreController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Store> getStore() {
        return storeService.getStores();
    }

    @PostMapping
    public String createStore(@RequestBody RequestStoreDTO storeDTO) {
        Location city = locationService.getLocationByCode(storeDTO.getLocationId());

        return storeService.addStore(new Store(
                city,
                storeDTO.getName(),
                storeDTO.getAddress(),
                storeDTO.getCode(),
                storeDTO.getDescription()
        ));
    }



}
