package com.example.prueba.domain;

import com.example.prueba.controller.in.RequestDto;
import com.example.prueba.domain.out.MessageDto;
import com.example.prueba.domain.out.ResponseDto;

public interface PruebaService {
    
    ResponseDto obtenerInfo(Integer petId);

    MessageDto crearInfo(RequestDto requestDto);
}
