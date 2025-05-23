package co.edu.umanizales.myfirstapii.controller;

import co.edu.umanizales.myfirstapii.model.Parameter;
import co.edu.umanizales.myfirstapii.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(path = "/parameters")
public class ParameterController {
    @Autowired
    private ParameterService parameterService;



    // Obtener todos los parámetros
    @GetMapping
    public List<Parameter> getAllParameters() {
        return parameterService.getAllParameters();
    }

    // Obtener parámetros por tipo
    @GetMapping("/typedocuments")
    public List<Parameter> getTypedDocuments() {
        return parameterService.getParametersByType(1);
    };

    @GetMapping("/typeproducts")
    public List<Parameter> getTypeProducts(){
        return parameterService.getParametersByType(2);
    }

    @GetMapping("/products")
    public List<Parameter> getProducts(){
        return parameterService.getParametersByType(3);
    }

    // Obtener un parámetro por su código
    @GetMapping("/{code}")
    public Parameter getParameterByCode(@PathVariable String code) {
        return parameterService.getParameterByCode(code);
    }

    // Agregar un parámetro nuevo
    @PostMapping("/")
    public void addParameter(@RequestBody Parameter parameter) {
        parameterService.addParameter(parameter);
    }
}
