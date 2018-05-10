package com.lukasaravanja.BankRESTwebapp.bankrestwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BankRestWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankRestWebAppApplication.class, args);
	}
}
