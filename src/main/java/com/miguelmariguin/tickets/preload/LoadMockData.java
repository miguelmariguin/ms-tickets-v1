package com.miguelmariguin.tickets.preload;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.miguelmariguin.tickets.controller.ButacaController;
import com.miguelmariguin.tickets.controller.DisponibilidadController;
import com.miguelmariguin.tickets.controller.FuncionController;
import com.miguelmariguin.tickets.controller.LugarController;
import com.miguelmariguin.tickets.controller.ReservaController;
import com.miguelmariguin.tickets.controller.SalaController;
import com.miguelmariguin.tickets.controller.ShowController;
import com.miguelmariguin.tickets.entity.Butaca;
import com.miguelmariguin.tickets.entity.Disponibilidad;
import com.miguelmariguin.tickets.entity.Funcion;
import com.miguelmariguin.tickets.entity.Lugar;
import com.miguelmariguin.tickets.entity.Reserva;
import com.miguelmariguin.tickets.entity.Sala;
import com.miguelmariguin.tickets.entity.Show;
import com.miguelmariguin.tickets.enums.SINO;
import com.miguelmariguin.tickets.enums.TipoLugar;

@Component
public class LoadMockData {

	@Autowired
	ButacaController butacaController;

	@Autowired
	FuncionController funcionController;

	@Autowired
	LugarController lugarController;

	@Autowired
	SalaController salaController;

	@Autowired
	ShowController showController;

	@Autowired
	ReservaController reservaController;

	@Autowired
	DisponibilidadController disponibilidadController;

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() throws ParseException {
		this.loadData();
	}
	
	public void loadData() throws ParseException{
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Random random = new Random();

		// CARGA DE LUGARES
		Lugar lugar = new Lugar();
		lugar.setNombre("Estadio José Amalfitani");
		lugar.setTipoLugar(TipoLugar.ESTADIO);
		lugarController.save(lugar);

		Lugar lugarb = new Lugar();
		lugarb.setNombre("Biblioteca Sarmiento");
		lugarb.setTipoLugar(TipoLugar.TEATRO);
		lugarController.save(lugarb);

		// CARGA DE SHOWS
		Show show = new Show();
		show.setFechaInicio(formatter.parse("2023-07-10 12:00:00"));
		show.setFechaFin(formatter.parse("2023-07-19 12:00:00"));
		show.setNombre("Stand Up - Juan Perez Show");
		show.setLugar(lugarb);
		showController.save(show);

		Show showb = new Show();
		showb.setFechaInicio(formatter.parse("2023-11-10 12:00:00"));
		showb.setFechaFin(formatter.parse("2023-11-10 12:00:00"));
		showb.setNombre("RHCP");
		showb.setLugar(lugar);
		showController.save(showb); 

		// CARGA DE SALAS
		Sala sala = new Sala();
		sala.setNombre("Sala A Biblioteca");
		salaController.save(sala);

		Sala salab = new Sala();
		salab.setNombre("Sala B Biblioteca");
		salaController.save(salab);

		// CARGA DE RESERVAS
		List<String> apellidos = Arrays.asList("García", "López", "Martínez", "González", "Rodríguez", "Hernández",
				"Pérez", "Sánchez", "Romero", "Fernández");
		List<String> nombres = Arrays.asList("Juan", "María", "Pedro", "Ana", "Luis", "Laura", "Carlos", "Sofía",
				"Miguel", "Isabella");
		for (int i = 1; i <= 9; i++) {
			int numero = random.nextInt(90000000) + 10000000;
			Reserva reserva = new Reserva();
			reserva.setApellidos(apellidos.get(random.nextInt(9) + 1));
			reserva.setNombres(nombres.get(random.nextInt(9) + 1));
			reserva.setDni(String.valueOf(numero));
			reservaController.save(reserva);
		}

		// CARGA DE FUNCIONES
		Funcion funciona = new Funcion();
		funciona.setNombre("Funcion Stand Up A");
		funciona.setIncluyeButaca(SINO.SI);
		String fechaHoraFuncion = "2023-07-05 17:00:00";
		funciona.setFechaHora(formatter.parse(fechaHoraFuncion));
		funciona.setShow(show);
		funciona.setSala(sala);
		funcionController.save(funciona);

		// CARGA DE FUNCIONES
		Funcion funcionrhcp = new Funcion();
		funcionrhcp.setNombre("fUN RHCP");
		funcionrhcp.setIncluyeButaca(SINO.NO);
		fechaHoraFuncion = "2023-11-10 22:00:00";
		funcionrhcp.setFechaHora(formatter.parse(fechaHoraFuncion));
		funcionrhcp.setShow(showb);
		funcionrhcp.setIncluyeButaca(SINO.NO);
		funcionController.save(funcionrhcp);
		// CARGA DE TICKETS PARA ESTADIO
		// PARA NO ALMACENAR DEMASIADOS REGISTROS COLOCARE
		// 10 ENTRADAS PARA EL ESTADIO
		for (int i = 0; i < 10; i++) {
			Disponibilidad disponibilidad = new Disponibilidad();
			disponibilidad.setDisponible(SINO.SI);
			disponibilidad.setPrecio((float) 500);
			disponibilidad.setFuncion(funcionrhcp);
			disponibilidadController.save(disponibilidad);
		}

		// CARGA DE BUTACAS
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j < 3; j++) {
				Butaca butaca = new Butaca();
				butaca.setCodigoButaca(Character.toString(65 + i) + "" + j);
				butaca.setSala(sala);
				butaca = butacaController.save(butaca);

				Disponibilidad disponibilidad = new Disponibilidad();
				disponibilidad.setDisponible(SINO.SI);
				disponibilidad.setPrecio((float) 100);
				disponibilidad.setFuncion(funciona);
				disponibilidad.setButaca(butaca);
				disponibilidad.setReserva(null);
				disponibilidadController.save(disponibilidad);
			}
		}

		
	}

}
