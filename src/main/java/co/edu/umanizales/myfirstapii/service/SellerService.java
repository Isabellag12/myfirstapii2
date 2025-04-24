package co.edu.umanizales.myfirstapii.service;

import co.edu.umanizales.myfirstapii.model.Seller;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;

public class SellerService {

    @Service
    @Getter
   public class sellerService {
        @Getter
        private List<seller> sellers;

        @Value ("${locations_filename}" )
        private string locationsFilename;

        @PostConstruct
        public void readLocationsFromCSV() throws I0Exeption {
            sellers = new ArrayList<>();

            sellers.add(new Seller("Isabella", "Ramirez", "19", "F","1054860051", "Manizales", ))
            sellers.add(new Seller("Juan", "Aristizabal", "21", "M","1056120560", "Manizales", ))
            sellers.add(new Seller("Adriana", "Garcia", "53", "F","30320916", "Pereira", ))
            sellers.add(new Seller("Samuel", "Lopez", "13", "M","", "Manizales", ))
        }


    }
}
