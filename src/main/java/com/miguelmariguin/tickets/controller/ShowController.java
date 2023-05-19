package com.miguelmariguin.tickets.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miguelmariguin.tickets.dto.ShowDetailDTO;
import com.miguelmariguin.tickets.entity.Disponibilidad;
import com.miguelmariguin.tickets.entity.Show;
import com.miguelmariguin.tickets.repository.IDisponibilidadRepo;
import com.miguelmariguin.tickets.repository.IFuncionRepo;
import com.miguelmariguin.tickets.repository.IShowRepo;

@RestController
public class ShowController {
	@Autowired
	IShowRepo showRepo;

	@Autowired
	IFuncionRepo funcionRepo;

	@Autowired
	IDisponibilidadRepo disponibilidadRepo;

	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@GetMapping("/show")
	public Show save(@RequestBody Show show) {
		try {
			return showRepo.save(show);
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping("/shows")
	public List<ShowDetailDTO> findAll(@RequestParam(value = "fechaInicio", required = false) String fechaInicio,
			@RequestParam(value = "fechaFin", required = false) String fechaFin,
			@RequestParam(value = "precioMin", required = false) Float precioMin,
			@RequestParam(value = "precioMax", required = false) Float precioMax) {
		try {
			List<Show> shows = new ArrayList<>();

			if ((precioMin != null) || (precioMax != null)) {
				shows = this.showsConPrecio(fechaInicio, fechaFin, precioMin, precioMax);

			} else {
				if ((fechaInicio != null) || (fechaFin != null)) {
					shows = showRepo.buscarRegistrosEntreFechas(formatter.parse(fechaInicio + " 00:00:00"),
							formatter.parse(fechaFin + " 00:00:00"));
				} else {
					shows = showRepo.findAll();
				}
			}
			List<ShowDetailDTO> showDetailList = new ArrayList<>();
			for (Show show : shows) {
				ShowDetailDTO showDetail = new ShowDetailDTO();
				showDetail.setShow(show);
				showDetail.setFunciones(funcionRepo.getFuncionByShow(show.getId()));
				showDetailList.add(showDetail);
			}

			return showDetailList;
		} catch (Exception e) {
			return null;
		}
	}

	private List<Show> filter(List<Show> shows, String fechaInicio, String fechaFin) throws ParseException {

		Date fi = formatter.parse(fechaInicio + " 00:00:00");
		Date ff = formatter.parse(fechaFin + " 00:00:00");
		List<Show> showsTemp = new ArrayList<>();

		if ((fechaInicio != null) && (fechaFin != null)) {
			for (Show show : shows) {
				System.out.println(show.getFechaFin());

				if ((fi.compareTo(show.getFechaInicio()) < 0) && (show.getFechaFin().compareTo(ff) < 0)) {
					showsTemp.add(show);

				}
			}
			if (showsTemp != null) {
				shows = showsTemp;
			}
		}

		return shows;

	}

	public static void agregarSinDuplicados(List<Show> shows, Show show) {
		if (!shows.contains(show)) {
			shows.add(show);
		}
	}

	private List<Show> showsConPrecio(String fechaInicio, String fechaFin, Float precioMin, Float precioMax)
			throws ParseException {
		List<Show> shows = new ArrayList<>();
		List<Disponibilidad> dispo = new ArrayList<>();

		dispo = disponibilidadRepo.getDisponibilidadByPrecio(precioMin, precioMax);

		for (Disponibilidad disponibilidad : dispo) {
			if (disponibilidad.getFuncion() != null) {
				agregarSinDuplicados(shows, disponibilidad.getFuncion().getShow());
			}
		}
		if ((fechaInicio != null) || (fechaFin != null)) {
			shows = this.filter(shows, fechaInicio, fechaFin);
		}
		return shows;
	}

}
