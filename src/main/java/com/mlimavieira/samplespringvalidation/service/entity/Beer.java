package com.mlimavieira.samplespringvalidation.service.entity;

import lombok.Data;

@Data
public class Beer {

    private Long id;
    private String name;
    private String type;
    private Double price;

}
