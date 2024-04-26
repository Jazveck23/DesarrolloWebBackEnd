package com.microservice.users.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="roles")
public class Role implements Serializable{
	
	private static final long serialVersionUID = 8550556477721078417L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(unique = true, length = 30)
	private String nombre;

	
	
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}
	
	
	

}
