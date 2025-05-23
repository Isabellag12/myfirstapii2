package co.edu.umanizales.myfirstapii.service;

import co.edu.umanizales.myfirstapii.model.Location;
import co.edu.umanizales.myfirstapii.model.Seller;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class SellerService {

    private List<Seller> sellers = new ArrayList<>();

    public String addSeller(Seller seller) {
        sellers.add(seller);
        return "Tienda agregada";
    }

    public Seller getSellerByCode(String code) {
        for (Seller seller : sellers) {
            if (seller.getCode().equals(code)) {
                return seller;
            }
        }
        return null;
    }
}


