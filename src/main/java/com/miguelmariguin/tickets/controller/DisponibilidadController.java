package com.miguelmariguin.tickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miguelmariguin.tickets.entity.Disponibilidad;
import com.miguelmariguin.tickets.repository.IDisponibilidadRepo;

@RestController
public class DisponibilidadController {

	@Autowired
	IDisponibilidadRepo disponibilidadRepo;

	@GetMapping("/disponibilidad")
	public Disponibilidad save(@RequestBody Disponibilidad disponibilidad) {
		try {
			return disponibilidadRepo.save(disponibilidad);
		} catch (Exception e) {
			return null;
		}
	}

}
