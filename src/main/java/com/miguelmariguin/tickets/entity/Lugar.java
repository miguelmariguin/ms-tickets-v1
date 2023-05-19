package com.miguelmariguin.tickets.entity;

import com.miguelmariguin.tickets.enums.TipoLugar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_lugar")
public class Lugar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private TipoLugar tipoLugar;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TipoLugar getTipoLugar() {
		return tipoLugar;
	}
	public void setTipoLugar(TipoLugar tipoLugar) {
		this.tipoLugar = tipoLugar;
	}
	
}
