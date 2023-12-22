package com.example.PennantApI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class PennantApIApplication {

	public static void main(String[] args) {
		SpringApplication.run(PennantApIApplication.class, args);
	}

}
