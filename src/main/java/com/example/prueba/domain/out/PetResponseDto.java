package com.example.prueba.domain.out;

import java.util.List;

import lombok.Data;

@Data
public class PetResponseDto {
    private String id;
    private CategoryDto category;
    private String name;
    private List<String> photoUrls;
    private List<TagDto> tags;
    private String status;
}
