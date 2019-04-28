package com.mlimavieira.samplespringvalidation.service;

import com.mlimavieira.samplespringvalidation.controller.dto.BeerDto;
import com.mlimavieira.samplespringvalidation.service.entity.Beer;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Validated
public class BeerService {


    public List<Beer> list( ) {
        return new ArrayList<>();
    }

    public Beer update(Long id, @Valid Beer beer) {

        beer.setId(id);
        return beer;
    }

    public Beer create(@Valid Beer beer) {

        beer.setId(new Random().nextLong());
        return beer;
    }


}
