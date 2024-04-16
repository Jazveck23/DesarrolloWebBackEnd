package com.microservice.cellphones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.cellphones.entity.Cellphone;
import com.microservice.cellphones.repository.CellphoneDao;

@Service
public class CellphoneServiceImpl implements CellphoneService {

	@Autowired
	private CellphoneDao celdao;
	@Override
	public List<Cellphone> findAll() {
		return (List<Cellphone>) celdao.findAll();
	}

	@Override
	public Cellphone findById(Long id) {
		return celdao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		celdao.deleteById(id);
	}

	@Override
	public Cellphone save(Cellphone instance) {
		return celdao.save(instance);
	}

	@Override
	public boolean existsById(Long id) {	
		return celdao.existsById(id);
	}

}
