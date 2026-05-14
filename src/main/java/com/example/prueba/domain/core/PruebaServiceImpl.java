package com.example.prueba.domain.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.prueba.client.CreateDatosClient;
import com.example.prueba.client.ObtenerDatosClient;
import com.example.prueba.controller.in.RequestDto;
import com.example.prueba.domain.PruebaService;
import com.example.prueba.domain.out.MessageDto;
import com.example.prueba.domain.out.PetResponseDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PruebaServiceImpl implements PruebaService {

    @Autowired
    private ObtenerDatosClient obtenerDatosClient;

    @Autowired
    private CreateDatosClient createDatosClient;

    public PetResponseDto obtenerInfo(final Integer petId) {
        ResponseEntity<PetResponseDto> response = obtenerDatosClient.getPet(petId);
        PetResponseDto petResponse = response.getBody();
        if (petResponse == null) {
            throw new IllegalStateException("No se obtuvo respuesta de Petstore para petId=" + petId);
        }

        printInfo(petResponse);

        return petResponse;
    }

    @Override
    public MessageDto crearInfo(RequestDto requestDto) {
        if (requestDto == null) {
            throw new IllegalArgumentException("RequestDto no puede ser nulo");
        }
        
        ResponseEntity<PetResponseDto> response = createDatosClient.createPet(requestDto);
        
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new IllegalStateException("Error en la creación del Pet. Código de estado: " + response.getStatusCode());
        }
        
        PetResponseDto petResponse = response.getBody();
        if (petResponse == null) {
            throw new IllegalStateException("Error al crear Pets para petId=" + requestDto.getId());
        }

        printInfo(petResponse);

        String dateCreated = response.getHeaders().getFirst("date");
        if (dateCreated == null) {
            throw new IllegalStateException("Error al obtener la fecha de creación del Pet");
        }

        MessageDto messageDto = new MessageDto();
        messageDto.setTransaccionId(petResponse.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            messageDto.setDateCreated(sdf.parse(dateCreated));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        messageDto.setStatus(true);
        messageDto.setName(petResponse.getName());
        return messageDto;  
    }
    
    private void printInfo(PetResponseDto petResponse) {
        log.info("Petstore pet loaded: id={}, name={}, status={}",
            petResponse.getId(),
            petResponse.getName(),
            petResponse.getStatus());
    }
}
