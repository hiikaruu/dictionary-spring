package com.example.dictionaryspring;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DictionarySpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(DictionarySpringApplication.class, args);
	}
	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder()
				.group("api")
				.pathsToMatch("/api/v1")
				.build();
	}

}
