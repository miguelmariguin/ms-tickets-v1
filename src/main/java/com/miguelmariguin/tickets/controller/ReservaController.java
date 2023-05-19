package com.miguelmariguin.tickets.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miguelmariguin.tickets.dto.CompraDTO;
import com.miguelmariguin.tickets.dto.ReservaDTO;
import com.miguelmariguin.tickets.entity.Disponibilidad;
import com.miguelmariguin.tickets.entity.Reserva;
import com.miguelmariguin.tickets.enums.SINO;
import com.miguelmariguin.tickets.repository.IDisponibilidadRepo;
import com.miguelmariguin.tickets.repository.IFuncionRepo;
import com.miguelmariguin.tickets.repository.IReservaRepo;

@RestController
@EnableAsync
public class ReservaController {
	@Autowired
	IFuncionRepo funcionRepo;
	@Autowired
	IReservaRepo reservaRepo;
	@Autowired
	IDisponibilidadRepo disponibilidadRepo;

//    @Async
	@GetMapping("/reserva")
	public Reserva save(@RequestBody Reserva reserva) {
		try {
			return reservaRepo.save(reserva);
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping("/createReserva")
	public ResponseEntity<String> createReserva(@RequestBody ReservaDTO reserva) {
		try {
			if (reserva.getReserva() != null) {
				Reserva reservaNueva = reservaRepo.save(reserva.getReserva());
				if (reserva.getCompra() != null) {
					for (CompraDTO compra : reserva.getCompra()) {
						List<Disponibilidad> disponibilidadList = disponibilidadRepo
								.getDisponibilidadNullByFuncion((long) compra.getFuncion_id());
						List<Disponibilidad> disponibilidadCompra = new ArrayList<>();
						int cantidad = compra.getCantidad();
						int contadorDeCompra = 0;
						for (Disponibilidad disponibilidad : disponibilidadList) {
							if (cantidad == contadorDeCompra) {
								break;
							}
							if (disponibilidad.getPrecio().equals(compra.getPrecio())) {
								disponibilidad.setDisponible(SINO.NO);
								disponibilidad.setReserva(reservaNueva);
								disponibilidadCompra.add(disponibilidad);
							}
							contadorDeCompra++;
						}

						if (contadorDeCompra != cantidad) {
							return ResponseEntity.status(HttpStatus.CONFLICT)
									.body("No hay más entradas disponibles para la venta");
						} else {

							disponibilidadRepo.saveAll(disponibilidadCompra);
						}
					}
				}
			}
			return ResponseEntity.status(HttpStatus.CREATED).body("Recurso creado exitosamente");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Mensaje de error");
		}
	}
}
