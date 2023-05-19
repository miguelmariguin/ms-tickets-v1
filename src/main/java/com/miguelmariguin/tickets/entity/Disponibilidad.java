package com.miguelmariguin.tickets.entity;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.miguelmariguin.tickets.enums.SINO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_disponibilidad")
public class Disponibilidad {
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private java.util.UUID ticket;
	
	public java.util.UUID getTicket() {
		return ticket;
	}
	public void setTicket(java.util.UUID ticket) {
		this.ticket = ticket;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="butaca_id", nullable=true)
    @JsonBackReference
	private Butaca butaca;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="funcion_id", nullable=true)
    @JsonBackReference
	private Funcion funcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="reserva_id", nullable=true)
    @JsonBackReference
	private Reserva reserva;
	
	private Float precio;
	private SINO disponible;
	
	public Butaca getButaca() {
		return butaca;
	}
	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}
	public Funcion getFuncion() {
		return funcion;
	}
	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public SINO getDisponible() {
		return disponible;
	}
	public void setDisponible(SINO disponible) {
		this.disponible = disponible;
	}
	
	
}
