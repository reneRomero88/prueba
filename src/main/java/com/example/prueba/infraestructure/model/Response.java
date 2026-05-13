package com.example.prueba.infraestructure.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Response {
    private Integer petId;
    private String name;
    private String status;
}
