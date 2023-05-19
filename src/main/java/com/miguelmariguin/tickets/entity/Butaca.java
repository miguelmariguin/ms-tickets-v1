package com.miguelmariguin.tickets.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_butaca")
public class Butaca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigoButaca;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sala_id", nullable=true)
    @JsonBackReference
	private Sala sala;
	
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigoButaca() {
		return codigoButaca;
	}
	public void setCodigoButaca(String codigoButaca) {
		this.codigoButaca = codigoButaca;
	}
	

}
