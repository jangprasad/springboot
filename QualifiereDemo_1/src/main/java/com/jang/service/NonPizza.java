package com.jang.service;

import org.springframework.stereotype.Component;

@Component
public class NonPizza implements Pizza{


    @Override
    public String getPizza() {
        return "Nonveg Piza";
    }
}
