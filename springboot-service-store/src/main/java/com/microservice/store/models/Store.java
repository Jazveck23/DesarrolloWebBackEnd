package com.microservice.store.models;

public class Store {
	
	private Cellphone cel;
	
	private Integer cantidad;
	
	
	public Store() { //constructor vacio para crear instancias, modificarlas, etc.
		
	}

	public Store(Cellphone cel, Integer cantidad) {
		super();
		this.cel = cel;
		this.cantidad = cantidad;
	}

	public Cellphone getCel() {
		return cel;
	}

	public void setCel(Cellphone cel) {
		this.cel = cel;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	

}
