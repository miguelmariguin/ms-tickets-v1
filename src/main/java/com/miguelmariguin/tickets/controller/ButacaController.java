package com.miguelmariguin.tickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miguelmariguin.tickets.entity.Butaca;
import com.miguelmariguin.tickets.repository.IButacaRepo;

@RestController
public class ButacaController {

	@Autowired
	IButacaRepo butacaRepo;

	@GetMapping("/butaca")
	public Butaca save(@RequestBody Butaca drone) {
		try {
			return butacaRepo.save(drone);
		} catch (Exception e) {
			return null;
		}
	}

}
