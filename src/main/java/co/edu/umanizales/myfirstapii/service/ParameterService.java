package co.edu.umanizales.myfirstapii.service;

import co.edu.umanizales.myfirstapii.model.Parameter;
import co.edu.umanizales.myfirstapii.model.Product;
import co.edu.umanizales.myfirstapii.model.TypeDocument;
import co.edu.umanizales.myfirstapii.model.TypeProduct;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Service
@Getter

public class ParameterService {
    private List<Parameter> parameters= new ArrayList<>();

    @Value("${typeDocument_filename}")
    private String typeDocumentFilename;

    @Value("${typeProduct_filename}")
    private String typeProductFilename;

    @Value("${product_filename}")
    private String productFilename;
    @PostConstruct

    public void readLocationsFromCSV() throws IOException {
        loadTypeDocuments();
        loadTypeProducts();
        loadProducts();
    }

    private void loadTypeDocuments() throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource(typeDocumentFilename).getFile()))) {
            reader.skip(1); // saltar encabezado
            String[] line;
            while ((line = reader.readNext()) != null) {
                TypeDocument td = new TypeDocument(line[0],line[1]);
                parameters.add(td);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException("Error leyendo typeDocument CSV", e);
        }
    }

    private void loadTypeProducts() throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource(typeProductFilename).getFile()))) {
            reader.skip(1);
            String[] line;
            while ((line = reader.readNext()) != null) {
                TypeProduct tp = new TypeProduct(line[0], line[1]);
                parameters.add(tp);

            }
        } catch (CsvValidationException e) {
            throw new RuntimeException("Error leyendo typeProduct CSV", e);
        }
    }

    private void loadProducts() throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource(productFilename).getFile()))) {
            reader.skip(1);
            String[] line;
            while ((line = reader.readNext()) != null) {
                Product p = new Product(line[0],line[1],Double.parseDouble(line[2]),parseInt(line[3]), getParameterByCode(line[4]) );
                parameters.add(p);

            }
        } catch (CsvValidationException | NumberFormatException e) {
            throw new RuntimeException("Error leyendo product CSV", e);
        }
    }



    // add parameter, agregar parametro
    public void addParameter(Parameter parameter) {
        parameters.add(parameter);
    }

    // Retorna todos los parámetros de todos los tipos
    public List<Parameter> getAllParameters(){
        return parameters;
    }


    // Filtra parámetros por tipo
    public List<Parameter> getParametersByType(int type){ ;
        List<Parameter> result = new ArrayList<>();
        for(Parameter parameter : parameters){
            switch(type){
                case 1:
                    if(parameter instanceof TypeDocument){
                        result.add(parameter);
                    }
                    break;
                case 2:
                    if(parameter instanceof TypeProduct){
                        result.add(parameter);
                    }
                    break;
                case 3:
                    if(parameter instanceof Product){
                        result.add(parameter);
                    }
                    break;


            }
        }
        return result;
    }


    // Busca un parámetro por su código en todas las listas,actualParameter es para buscar un parametro
    public Parameter getParameterByCode(String code) {
        for (Parameter actualParameter : parameters) {
            if (actualParameter.getCode().equals(code)) {
                return actualParameter; // retorna el primero que encuentra
            }
        }
        return null; // si no encuentra coincidencias
    }
}