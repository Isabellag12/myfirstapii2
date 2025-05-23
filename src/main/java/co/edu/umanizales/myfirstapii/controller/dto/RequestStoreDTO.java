package co.edu.umanizales.myfirstapii.controller.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class RequestStoreDTO {
    private String locationId;
    private String name;
    private String address;
    private String description;
    private String code;
}
