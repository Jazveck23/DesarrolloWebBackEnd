package com.microservice.cellphones.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.cellphones.entity.Cellphone;
import com.microservice.cellphones.services.CellphoneService;



@RestController
public class CellphoneController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CellphoneService service;
	
	@Value("${server.port}") //controlador para tener acceso al puerto yml
	private Integer port;
	
	@GetMapping("/list")//ruta de acceso a la lista o los registros de la tabla
	public List<Cellphone> list(){
		return service.findAll().stream().map(cel -> {
			cel.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return cel;
		}).collect(Collectors.toList());	//retorno listado de celular y no el iterable
	}
	
	@GetMapping("/cellphone/{id}")
	public Cellphone detail(@PathVariable Long id) {
		
		try {
			Thread.sleep(2000L);
			
		}catch(InterruptedException e) {
			
			e.printStackTrace();
			
		}
		return service.findById(id);	
	}
	
	@DeleteMapping("/cellphone/{id}") //busca mediante el id del modelo para eliminar
	public ResponseEntity<Void> drop(@PathVariable Long id){ 
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}	
	
	
	@PostMapping("/cellphone") //guarda registro
	public ResponseEntity<Cellphone> add(@RequestBody Cellphone instance){ //se recibe un body JSON con estructura celular
		Cellphone cel = service.save(instance);
		return new ResponseEntity<>(cel, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/cellphone/{id}") //se recibe un id para saber que registro modificar
	public ResponseEntity<Cellphone> update(@PathVariable Long id,@RequestBody Cellphone instance){
		
		if(service.existsById(id)) { //revisa si es que existe el ID que se solicita modificar
			instance.setId(id);
			Cellphone cel = service.save(instance);
			return new ResponseEntity<>(cel, HttpStatus.OK);	
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

}
