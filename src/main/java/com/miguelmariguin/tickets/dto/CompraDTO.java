package com.miguelmariguin.tickets.dto;

public class CompraDTO {
	private int cantidad;
	private float precio;
	private int funcion_id;
	
	public int getFuncion_id() {
		return funcion_id;
	}
	public void setFuncion_id(int funcion_id) {
		this.funcion_id = funcion_id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
