package co.edu.umanizales.myfirstapii.controller.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data


public class RequestSaleDTO
{
    private String storeId;
    private String sellerId;
    private LocalDate dateSale;
    private int quantity;
    private List<RequestProductDTO> products;
    private String code;
}
