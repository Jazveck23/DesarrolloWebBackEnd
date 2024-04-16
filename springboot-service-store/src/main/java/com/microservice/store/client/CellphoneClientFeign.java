package com.microservice.store.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.microservice.store.models.Cellphone;

@FeignClient(name = "service-cellphones")
public interface CellphoneClientFeign {
	
	@GetMapping("/list")
	public List<Cellphone> list();
		
	@GetMapping("/cellphone/{id}")
	public Cellphone detail(@PathVariable Long id);
	
	
			

}
