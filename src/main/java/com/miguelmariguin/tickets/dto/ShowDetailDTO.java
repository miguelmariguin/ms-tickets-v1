package com.miguelmariguin.tickets.dto;

import java.util.List;

import com.miguelmariguin.tickets.entity.Funcion;
import com.miguelmariguin.tickets.entity.Show;

public class ShowDetailDTO {
	private Show show;
	private List<Funcion> funciones;
	
	public ShowDetailDTO() {
		this.funciones = null;
	}
	
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public List<Funcion> getFunciones() {
		return funciones;
	}
	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}
	
}
