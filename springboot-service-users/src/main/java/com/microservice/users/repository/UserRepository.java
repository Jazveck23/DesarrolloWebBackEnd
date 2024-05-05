package com.microservice.users.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.microservice.commons.users.entity.Usuario;

@RepositoryRestResource(path = "users")
public interface UserRepository extends PagingAndSortingRepository<Usuario, Long>{	
	
	//select from usuario where id =
	@RestResource(path = "buscar-username")
	public Usuario findByUsername(String username); //se apunta directamente al objeto
	
	
	//select from usuario where id = and email =
	public Usuario findByUsernameAndEmail(String username, String email);
	

	@Query(value = "select u from Usuario u where u.username = ?1")
	public Usuario obtenerPorUsername(String username);
	
	@Query(value = "select u from Usuario u where u.username = ?1 and u.email = ?2")
	public Usuario obtenerPorUsernameYEmail(String username, String email);
	
}
