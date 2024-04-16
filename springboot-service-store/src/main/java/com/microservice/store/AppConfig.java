package com.microservice.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//este servicio no se conecta mediante un Dao, se utiliza un rest Template

//Esta clase configura el Rest Template

@Configuration
public class AppConfig {
	
	@Bean("ClientRest")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
	
}
