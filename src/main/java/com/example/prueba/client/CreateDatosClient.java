package com.example.prueba.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.prueba.controller.in.RequestDto;
import com.example.prueba.domain.out.PetResponseDto;

@FeignClient(name = "CreateDatosClient", url = "${service.petstore.url}")
public interface CreateDatosClient {

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PetResponseDto> createPet(@RequestBody RequestDto requestDto);
}
