package co.edu.umanizales.myfirstapii.service;

import co.edu.umanizales.myfirstapii.model.Product;
import co.edu.umanizales.myfirstapii.model.Sale;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {
    private List<Sale> sales = new ArrayList<>();

    // crear una venta
    public void addSale(Sale sale) {
        sales.add(sale);
    }

    // Obtener todas las ventas
    public List<Sale> getAllSales() {
        return sales;
    }

    // Buscar una venta por código
    public Sale getSaleByCode(String code) {
        for (Sale saleActual : sales) {
            if (saleActual.getCode().equals(code)) {
                return saleActual;
            }
        }
        return null;
    }

    // Listar ventas por código de tienda
    public List<Sale> getSalesByStoreCode(String storeCode) {
        List<Sale> result = new ArrayList<>();
        for (Sale s : sales) {
            if (s.getStore().getCode().equals(storeCode)) {
                result.add(s);
            }
        }
        return result;
    }

    // Listar ventas por código de vendedor
    public List<Sale> getSalesBySellerCode(String sellerCode) {
        List<Sale> result = new ArrayList<>();
        for (Sale s : sales) {
            if (s.getSeller().getCode().equals(sellerCode)) {
                result.add(s);
            }
        }
        return result;
    }

    // Listar ventas por código de producto
    public List<Sale> getSalesByProductCode(String productCode) {
        List<Sale> result = new ArrayList<>();
        for (Sale sale : sales) {
            if (sale.getProducts() != null) {
                for (Product product : sale.getProducts()) {
                    if (product.getCode().equals(productCode)) {
                        result.add(sale);

                    }
                }
            }
        }
        return result;
    }

    // Listar ventas por fecha exacta (usando String)
    public List<Sale> getSalesByDate(String date) {
        LocalDate dateF =LocalDate.parse(date);
        List<Sale> result = new ArrayList<>();
        for (Sale s : sales) {

            if (s.getDateSale().equals(dateF)) {
                result.add(s);
            }
        }
        return result;
    }
}
