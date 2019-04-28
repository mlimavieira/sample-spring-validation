package com.mlimavieira.samplespringvalidation.controller.dto;

import lombok.Data;

@Data
public class BeerDto {

    private Long id;
    private String name;
    private String type;
    private Double price;


}
