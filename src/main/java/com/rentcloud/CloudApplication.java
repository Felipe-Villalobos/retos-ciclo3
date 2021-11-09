package com.rentcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.rentcloud.app.entities"})
@SpringBootApplication
public class CloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApplication.class, args);
	}

}
