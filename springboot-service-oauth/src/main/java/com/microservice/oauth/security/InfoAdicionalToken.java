package com.microservice.oauth.security;


import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.microservice.commons.users.entity.Usuario;
import com.microservice.oauth.service.UsuarioService;

@Component
public class InfoAdicionalToken implements TokenEnhancer{

	@Autowired
	private UsuarioService service;
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<>();	
		
		Usuario user = service.findByUsername(authentication.getName());
		info.put("nombre", user.getNombre());
		info.put("Apellido", user.getApellido());
		info.put("Email", user.getEmail());
		info.put("Claim Prueba", "Valor de Prueba");
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
		
	}
	

}
 