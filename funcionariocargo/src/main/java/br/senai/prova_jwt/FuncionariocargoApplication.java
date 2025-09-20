package br.senai.prova_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true)
public class FuncionariocargoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuncionariocargoApplication.class, args);
	}

}
