package com.egramswaraj;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EGramSwarajApplication {

	public static void main(String[] args) {
		SpringApplication.run(EGramSwarajApplication.class, args); 
		
		System.out.println("Welcome to E-Gram Swaraj Application");
		
	
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}

}
