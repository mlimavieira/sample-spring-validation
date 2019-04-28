package com.mlimavieira.samplespringvalidation.service.entity;

import com.mlimavieira.samplespringvalidation.service.validators.BeerType;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class Beer {

    private Long id;
    @Min(10) @Max(50)
    private String name;

    @NotNull
    @BeerType
    private String type;

    @NotNull
    private Double price;

}
