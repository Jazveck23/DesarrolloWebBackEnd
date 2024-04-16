package com.microservice.cellphones.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.cellphones.entity.Cellphone;

@Service
public interface CellphoneService {
	
	//mantiene los servicios se manera estructurada sin ver la logjca de negocio 
	
	public List<Cellphone> findAll();
	
	public Cellphone findById(Long id);
	
	public void deleteById(Long id);
	
	public Cellphone save(Cellphone instance);
	
	public boolean existsById(Long id);
}
