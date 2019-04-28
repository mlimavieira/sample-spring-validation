package com.mlimavieira.samplespringvalidation.controller;

import com.mlimavieira.samplespringvalidation.controller.dto.BeerDto;
import com.mlimavieira.samplespringvalidation.controller.dto.Message;
import com.mlimavieira.samplespringvalidation.service.BeerService;
import com.mlimavieira.samplespringvalidation.service.entity.Beer;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @Autowired
    private BeerService beerService;

    @Autowired
    private DozerBeanMapper dozer;

    @GetMapping
    public List<BeerDto> getBeers() {

        List<Beer> beers = beerService.list();

        return beers.stream().map(b -> dozer.map(b, BeerDto.class)).collect(Collectors.toList());
    }

    @PutMapping
    public BeerDto putBeer(@Valid @RequestBody BeerDto beerDto) {

        Beer beer = beerService.create(dozer.map(beerDto, Beer.class));
        return dozer.map(beer, BeerDto.class);
    }

    @PostMapping("/{id}")
    public BeerDto postBeer(@PathVariable("id") Long id, @Valid @RequestBody BeerDto beerDto) {

        Beer beer = beerService.update(id, dozer.map(beerDto, Beer.class));
        return dozer.map(beer, BeerDto.class);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected Message handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        Message message = new Message();
        message.setMessage("Ops! Something went wrong. (MethodArgumentNotValidException) ");

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            message.addError(error.getField(), error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            message.addError(error.getObjectName(), error.getDefaultMessage());
        }

        return message;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Message handleConstraintViolationException(ConstraintViolationException e) {
        Message message = new Message();
        message.setMessage("Ops! Something went wrong. (ConstraintViolationException) ");

        for (ConstraintViolation violation : e.getConstraintViolations()) {
            message.addError(violation.getPropertyPath().toString(), violation.getMessage());
        }
        return message;

    }

}
