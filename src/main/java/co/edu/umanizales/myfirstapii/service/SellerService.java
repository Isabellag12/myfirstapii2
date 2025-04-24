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
    @Autowired
    private LocationService locationService;

    @Getter
    private List<Seller> sellers;

    @Value("${seller_filename}")
    private String sellerFilename;

    @PostConstruct
    public void readLocationsFromCSV() throws IOException {
        sellers = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(
                new ClassPathResource(sellerFilename).getFile()))) {

            String[] line;
            csvReader.skip(1); // Omitir cabecera si aplica

            while ((line = csvReader.readNext()) != null) {
                sellers.add(new Seller((line[0]),line[1],Byte.parseByte(line[2]),line[3],line[4], (Location) locationService.getLocationByCode));
            }

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Error leyendo el archivo CSV", e);
        }
    }

}


