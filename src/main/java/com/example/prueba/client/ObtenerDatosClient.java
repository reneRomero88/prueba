package com.example.prueba.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.prueba.domain.out.PetResponseDto;

@FeignClient(name = "ObtenerDatosClient", url = "${service.petstore.url}")
public interface ObtenerDatosClient {

    @GetMapping(value = "{petId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PetResponseDto> getPet(@PathVariable("petId") Integer petId);
}
