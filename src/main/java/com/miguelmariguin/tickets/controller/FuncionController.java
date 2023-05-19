package com.miguelmariguin.tickets.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miguelmariguin.tickets.dto.FuncionDetailDTO;
import com.miguelmariguin.tickets.entity.Disponibilidad;
import com.miguelmariguin.tickets.entity.Funcion;
import com.miguelmariguin.tickets.enums.SINO;
import com.miguelmariguin.tickets.repository.IDisponibilidadRepo;
import com.miguelmariguin.tickets.repository.IFuncionRepo;

@RestController
public class FuncionController {

	@Autowired
	IFuncionRepo funcionRepo;

	@Autowired
	IDisponibilidadRepo disponibilidadRepo;

	@GetMapping("/funcion")
	public Funcion save(@RequestBody Funcion funcion) {
		try {
			return funcionRepo.save(funcion);
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping("/funcionDetail")
	public List<FuncionDetailDTO> getFuncionDetailByShow(@RequestParam("showId") Long showId) {
		try {
			List<Funcion> funcionList = funcionRepo.getFuncionByShow(showId);
			List<FuncionDetailDTO> funcionDetailDTOList = new ArrayList<>();

			for (Funcion funcion : funcionList) {
				FuncionDetailDTO funcionDetailDTO = new FuncionDetailDTO();
				List<Disponibilidad> disponibilidadListNull = new ArrayList<>();
				List<Disponibilidad> disponibilidadList = disponibilidadRepo
						.getDisponibilidadByFuncion(funcion.getId());
				int cantidadButacasDisponibles = 0;

				for (Disponibilidad disponibilidad : disponibilidadList) {
					if (disponibilidad.getReserva() == null) {
						disponibilidadListNull.add(disponibilidad);
						cantidadButacasDisponibles++;
					}
				}
				if (funcion.getIncluyeButaca().equals(SINO.SI)) {
					funcionDetailDTO.setButacas(disponibilidadListNull);
				}else {
					funcionDetailDTO.setEntradas(disponibilidadList);
				}
				funcionDetailDTO.setDisponibilidad(cantidadButacasDisponibles);
				funcionDetailDTO.setCapacidadDePersonas(disponibilidadList.size());
				funcionDetailDTO.setFuncion(funcion);
				funcionDetailDTOList.add(funcionDetailDTO);

			}

			return funcionDetailDTOList;
		} catch (Exception e) {
			return null;
		}
	}

}
