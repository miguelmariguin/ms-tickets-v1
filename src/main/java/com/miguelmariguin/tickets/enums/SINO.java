package com.miguelmariguin.tickets.enums;

import lombok.Getter;

@Getter
public enum SINO {

	SI(0, "Si"), 
	NO(1, "No");

	private int id;
	private String descripcion;

	private SINO(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return this.descripcion;
	}

}
