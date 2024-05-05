package com.microservice.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice.commons.users.entity.Usuario;

@FeignClient("service-commons-users")
public interface UsuarioFeignClient {
	
	@GetMapping("/users/search/buscar-username")
	public Usuario findByUsername (@RequestParam String username);
	
	

}
