package com.example.prueba.domain.out;

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
public class ResponseDto {
    
    private Integer petId;
    private String name;
    private String status;
}
