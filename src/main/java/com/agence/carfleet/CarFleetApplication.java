package com.agence.carfleet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CarFleetApplication {

	@Value("${car-fleet.origin}")
    private String origin;

	public static void main(String[] args) {
		SpringApplication.run(CarFleetApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(origin)
						.allowedMethods("GET", "POST", "PUT", "DELETE");
				;
			}
		};
	}

}
