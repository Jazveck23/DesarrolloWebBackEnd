package com.microservice.cellphones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootServiceCellphonesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceCellphonesApplication.class, args);
	}

}
