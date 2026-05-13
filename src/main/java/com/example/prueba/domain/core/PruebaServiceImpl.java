package com.example.prueba.domain.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.controller.in.RequestDto;
import com.example.prueba.domain.PruebaService;
import com.example.prueba.domain.out.MessageDto;
import com.example.prueba.domain.out.ResponseDto;
import com.example.prueba.infraestructure.PruebaRepository;
import com.example.prueba.infraestructure.model.Response;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PruebaServiceImpl implements PruebaService {

    @Autowired
    PruebaRepository repository;

    public ResponseDto obtenerInfo(final Integer petId) {
        Response response = repository.obtenerInfo(petId);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setPetId(response.getPetId());
        responseDto.setName(response.getName());
        responseDto.setStatus(response.getStatus());

        printInfo(response);
        return responseDto;
    }

    private void printInfo(final Response response) {
        log.info("PetId: {}", response.getPetId());
        log.info("Name: {}", response.getName());
        log.info("Status: {}", response.getStatus());
    }

    @Override
    public MessageDto crearInfo(RequestDto requestDto) {
        return repository.crearInfo(requestDto);    
    }
    
}
