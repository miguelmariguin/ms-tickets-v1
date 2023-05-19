package com.miguelmariguin.tickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miguelmariguin.tickets.entity.Lugar;
import com.miguelmariguin.tickets.repository.ILugarRepo;

@RestController
public class LugarController {
	@Autowired
	ILugarRepo lugarRepo;

	@GetMapping("/lugar")
	public Lugar save(@RequestBody Lugar lugar) {
		try {
			return lugarRepo.save(lugar);
		} catch (Exception e) {
			return null;
		}
	}
}
