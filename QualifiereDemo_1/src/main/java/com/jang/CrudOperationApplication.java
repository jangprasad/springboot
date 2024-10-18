package com.jang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudOperationApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(CrudOperationApplication.class, args);
		PizzaController con =(PizzaController)context.getBean("pizza");
		System.out.println(con.getPizza());


	}

}
