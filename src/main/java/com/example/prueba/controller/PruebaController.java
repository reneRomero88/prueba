package com.example.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.controller.in.RequestDto;
import com.example.prueba.domain.PruebaService;
import com.example.prueba.domain.out.MessageDto;
import com.example.prueba.domain.out.PetResponseDto;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping(value = "/api/pet")
public class PruebaController {

    @Autowired
    PruebaService service;

    @GetMapping(value = "/{petId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PetResponseDto> obtenerInformacion(@PathVariable final Integer petId) {

        PetResponseDto response = service.obtenerInfo(petId);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageDto> orquesta(@RequestBody final RequestDto req) {
        MessageDto response = service.crearInfo(req);
        return ResponseEntity.ok().body(response);
    }
}