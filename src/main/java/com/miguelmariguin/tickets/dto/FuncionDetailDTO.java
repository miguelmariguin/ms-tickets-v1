package com.miguelmariguin.tickets.dto;

import java.util.List;

import com.miguelmariguin.tickets.entity.Disponibilidad;
import com.miguelmariguin.tickets.entity.Funcion;

public class FuncionDetailDTO {
	private Funcion funcion;
	private List<Disponibilidad> butacas;
	private List<Disponibilidad> entradas;
	private int capacidadDePersonas;
	private int disponibilidad;

	public List<Disponibilidad> getEntradas() {
		return entradas;
	}
	public void setEntradas(List<Disponibilidad> entradas) {
		this.entradas = entradas;
	}
	public int getCapacidadDePersonas() {
		return capacidadDePersonas;
	}
	public void setCapacidadDePersonas(int capacidadDePersonas) {
		this.capacidadDePersonas = capacidadDePersonas;
	}
	public int getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public Funcion getFuncion() {
		return funcion;
	}
	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}
	public List<Disponibilidad> getButacas() {
		return butacas;
	}
	public void setButacas(List<Disponibilidad> butacas) {
		this.butacas = butacas;
	}

}
