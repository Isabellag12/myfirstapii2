package co.edu.umanizales.myfirstapii.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;


@Getter
@Setter
@AllArgsConstructor
public class Sale {
    private Store Store;
    private Seller Seller;
    private LocalDate dateSale;
    private int quantity;
    private List<Product> products;
    private String code;

}
