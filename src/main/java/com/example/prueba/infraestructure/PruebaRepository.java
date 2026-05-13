package com.example.prueba.infraestructure;

import org.springframework.stereotype.Component;

import com.example.prueba.controller.in.RequestDto;
import com.example.prueba.domain.out.MessageDto;
import com.example.prueba.infraestructure.model.Response;

@Component
public class PruebaRepository {
    
    public Response obtenerInfo(final Integer petId) {
        Response response = new Response();
        response.setPetId(petId);
        response.setName("testingPet1");
        response.setStatus("available");
        return response;
    }

    public MessageDto crearInfo(final RequestDto requestDto) {
        MessageDto response = new MessageDto();
        response.setTransaccionId("123456789");
        response.setDateCreated(new java.sql.Date(System.currentTimeMillis()));
        response.setStatus(true);
        response.setName(requestDto.getName());
        return response;
    }
}
