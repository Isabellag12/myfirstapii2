package co.edu.umanizales.myfirstapii.service;

import co.edu.umanizales.myfirstapii.model.Location;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class LocationService {

    public Object getLocationByCode;
    private List<Location> locations;

    @Value( "${locations_filename}" )
    private String locationsFilename;

    @PostConstruct
    public void readLocationsFromCSV() throws IOException, URISyntaxException {
        locations = new ArrayList<>();
        locations.add(new Location("05","ANTIOQUIA"));
        locations.add(new Location("17","CALDAS"));
        locations.add(new Location("66","RISARALDA"));

        Path pathFile = Paths.get(ClassLoader.getSystemResource(locationsFilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1);
            // Leer todas las filas del CSV
            while ((line = csvReader.readNext()) != null) {

                // Crear un nuevo objeto Location y agregarlo a la lista
                locations.add(new Location(line[2],line[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;  // Lanza la excepción para que pueda manejarse en la capa superior si es necesario
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public Location getLocationByCode(String code) {
        for (Location location : locations) {
            if (location.getCode().equals(code)) {
                return location;
            }
        }
        return null;
    }

    public List<Location> getStates() {
        List<Location> states = new ArrayList<>();
        for (Location location : locations) {
            if(location.getCode().length() ==2){
                states.add(location);
            }
        }
        return states;
    }

    public Location getLocationByName(String name) {
        for (Location location : locations) {
            if (location.getDescription().equals(name)) {
                return location;
            }
        }
        return null;
    }
    public List<Location> getLocationByInitialLetter (String initialLetter) {
        List<Location> initialLetterArray = new ArrayList<>();
        for (Location location : locations) {
            if(location.getDescription().charAt(0)== initialLetter.charAt(0)){
                initialLetterArray.add(location);
            }
        }
        //esta parte del codigo hace que yo le de un numero, un caracter y me arroja las ciudades
        //y departamentos que tengan mas de los caracteres pedidos
        //el rest es donde los métodos devolverán datos directamente en la respuesta
//Inyección de dependencia del servicio LocationService
//get all locations es el controlador
//get states devuelve una lista de Location objetos cuyo código tiene una longitud de 2 caracteres.
//@PathVariable es una anotación de Spring
//int es un tipo de dato primitivo en Java que representa un número entero
//minLength: Es la variable que almacena el valor entero de la longitud mínima proporcionada en la URL.

        return initialLetterArray;
    } public List<Location> getLocationsByMinNameLength (int minCaracteres) {
        List<Location> result = new ArrayList<>();
        for (Location location : locations) {
            if (location.getDescription().length() > minCaracteres) {
                result.add(location);
            }
        }
        return result;
    }
}
