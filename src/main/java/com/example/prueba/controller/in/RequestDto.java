package com.example.prueba.controller.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    
    private Integer petId;
    private String name;
    private String status;
}
