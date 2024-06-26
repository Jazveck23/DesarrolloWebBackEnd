package com.microservice.cellphones.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //configuracion de Spring
@EnableSwagger2 //clase que permite cargar configuracion de swagger
public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.microservice.cellphones.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
		
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("Celulares"
				,"Servicio para venta Celulares"
				,"1.0.0",
				"Terminos de servicios",
				new Contact("Gustavo","https://www.google.com","gustavo.rodriguez@uanl.edu.mx"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}
}
