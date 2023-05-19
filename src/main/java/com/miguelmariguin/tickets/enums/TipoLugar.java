package com.miguelmariguin.tickets.enums;

import lombok.Getter;

@Getter
public enum TipoLugar {

	TEATRO(0, "Teatro"), 
	ESTADIO(1, "Estadio"), 
	CAMPO(2, "Campo"), 
	OTROS(3, "Otros");

	private int id;
	private String descripcion;

	private TipoLugar(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return this.descripcion;
	}

}
