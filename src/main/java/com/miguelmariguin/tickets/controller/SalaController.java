package com.miguelmariguin.tickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miguelmariguin.tickets.entity.Sala;
import com.miguelmariguin.tickets.repository.ISalaRepo;

@RestController
public class SalaController {
	@Autowired
	ISalaRepo salaRepo;

	@GetMapping("/sala")
	public Sala save(@RequestBody Sala sala) {
		try {
			return salaRepo.save(sala);
		} catch (Exception e) {
			return null;
		}
	}
}
