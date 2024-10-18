package com.jang.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class NonPizza implements Pizza{


    @Override
    public String getPizza() {
        return "Nonveg Piza";
    }
}
