package com.miguelmariguin.tickets.enums;

import lombok.Getter;

@Getter
public enum CategoriaShow {

	TEATRAL(0, "Teatral"), MUSICAL(1, "Musical"), STANDUP(2, "Stand Up"), OTROS(3, "Otros");

	private int id;
	private String descripcion;

	private CategoriaShow(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return this.descripcion;
	}

}
