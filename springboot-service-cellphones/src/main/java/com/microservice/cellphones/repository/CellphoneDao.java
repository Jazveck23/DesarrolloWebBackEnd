package com.microservice.cellphones.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservice.cellphones.entity.Cellphone;

public interface CellphoneDao extends CrudRepository<Cellphone, Long>{
}
