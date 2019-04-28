package com.mlimavieira.samplespringvalidation.controller.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Message {

    private String message;
    private Map<String, String> errors;


    public void addError(String field, String message) {
        if(errors == null) {
            this.errors = new HashMap<>();
        }

        errors.put(field, message);
    }
}

