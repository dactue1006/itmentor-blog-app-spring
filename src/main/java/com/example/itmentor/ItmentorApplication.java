package com.example.itmentor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ItmentorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItmentorApplication.class, args);
	}

}
