package com.jang;

import com.jang.service.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaController {

    private Pizza pizza;

     @Autowired
    public PizzaController(Pizza pizza)
    {
        this.pizza=pizza;
    }

    public String getPizza()
    {
        return pizza.getPizza();
    }
}
