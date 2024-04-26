package com.microservice.users.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
@Table(name="users")
public class User implements Serializable{
	
	
	private static final long serialVersionUID = 8550556477721078417L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	
	@Column(unique = true, length = 20)
	private String username;
	
	@Column(unique = true, length = 100)
	private String email;
	
	@Column(length = 60)
	private String password;
	
	
	private Boolean enabled;
	
	private String nombre;
	
	private String apellido;

	
	@ManyToMany(fetch = FetchType.LAZY) //Eager si obtenemos la informacion del usuario (AL CARGAR ALGUNA ALGUNA DE LAS ENTIDADES RELACIONADAS SE TRAERA TODOS LOS DATOS )
	//Lazy solo se activira o traera de la base de datos cuando se llame el rol
	@JoinTable(name = "usuarios_to_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rooles_id"), uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","rooles_id"})})
	private List <Role> roles;
	
	
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	
	
	

}
