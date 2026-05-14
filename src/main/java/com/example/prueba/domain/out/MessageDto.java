package com.example.prueba.domain.out;

import java.util.Date;

import lombok.Data;

@Data
public class MessageDto {
    
    private String transaccionId;
    private Date dateCreated;
    private boolean status;
    private String name;
}
