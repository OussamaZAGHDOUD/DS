package com.OZ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class RestaurantDsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantDsApplication.class, args);
	}
}
