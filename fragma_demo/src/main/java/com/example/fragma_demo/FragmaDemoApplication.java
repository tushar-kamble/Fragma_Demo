package com.example.fragma_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories
public class FragmaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FragmaDemoApplication.class, args);
	}

}
