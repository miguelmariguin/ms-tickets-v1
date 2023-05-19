package com.miguelmariguin.tickets.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.miguelmariguin.tickets.enums.SINO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_funcion")
public class Funcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private SINO incluyeButaca;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sala_id", nullable=true)
    @JsonBackReference
	private Sala sala;
//	@CreationTimestamp
//	@Column(name="fecha_hora")
	private Date fechaHora;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="show_id", nullable=true)
    @JsonBackReference
	private Show show;
	
	
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
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
	public SINO getIncluyeButaca() {
		return incluyeButaca;
	}
	public void setIncluyeButaca(SINO incluyeButaca) {
		this.incluyeButaca = incluyeButaca;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fecha) {
		this.fechaHora = fecha;
	}
	
	

}
