package com.miguelmariguin.tickets.dto;

import java.util.List;

import com.miguelmariguin.tickets.entity.Reserva;

public class ReservaDTO {
	private Reserva reserva;
	private List<CompraDTO> compra;
	
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public List<CompraDTO> getCompra() {
		return compra;
	}
	public void setCompra(List<CompraDTO> compra) {
		this.compra = compra;
	}

	
}
