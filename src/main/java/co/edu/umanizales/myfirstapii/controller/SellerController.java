package co.edu.umanizales.myfirstapii.controller;
import co.edu.umanizales.myfirstapii.model.Location;
import co.edu.umanizales.myfirstapii.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/Seller")
public class SellerController {
    @GetMapping
    public Seller getSaller(){
        Location Manizales = new Location("17001","Manizales");
        Location pereira = new Location("66001","Pereira");

    Seller Isabella = new Seller("Isabella","Ramirez", (byte) 19, "F" ,"1054860051",Manizales);
    Seller Juan = new Seller("Juan" ,"Aristizabal", (byte) 21 , "M" , "1056120560" , Manizales);
    Seller samuel = new Seller("samuel", "Lopez" , (byte) 13, "M", "1054769981" , Manizales);
    Seller Adriana = new Seller("Adriana", "Garcia" , (byte) 52, "F", "30320916" , Manizales);
    Seller Jhon = new Seller("Jhon", "Giraldo" , (byte) 56, "M", "10279795"  , Manizales);


        return Isabella;

    }



}
