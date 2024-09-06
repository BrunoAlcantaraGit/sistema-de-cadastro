package com.CRUD.sitema_de_cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient
@SpringBootApplication
public class SitemaDeCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SitemaDeCadastroApplication.class, args);
	}

}
