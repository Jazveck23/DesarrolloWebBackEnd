package com.microservice.cellphones.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity //persiste a la base de datos
@Table(name = "cellphones") //nombre de la tabla
public class Cellphone implements Serializable{
	
	private static final long serialVersionUID = 8550556477721078417L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; //id de la tabla
	
	private String name;
	
	private String marca;
	
	//se definen parametros para tipo fecha:
	@Column(name = "create_at") //nombre de la columna o el atributo en la tabla
	@Temporal(TemporalType.TIMESTAMP) //mas exacta ya que guarda la fecha y hora exacta
	private Date createAt;
	
	@Transient //no persiste a la base de datos
	private Integer port;

	
	
	//Getter y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
	
	
}
