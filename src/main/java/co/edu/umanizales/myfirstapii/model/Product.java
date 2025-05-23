package co.edu.umanizales.myfirstapii.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product extends Parameter{
    private double price;
    private int stock;
    private Parameter typeProduct;


    public Product(String code, String description, double price, int stock, Parameter typeProduct) {
        super(code, description);
        this.price = price;
        this.stock = stock;
        this.typeProduct = typeProduct;

    }

}
