package com.mlimavieira.samplespringvalidation.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BeerDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private Double price;


}
