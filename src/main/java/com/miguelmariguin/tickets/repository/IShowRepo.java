package com.miguelmariguin.tickets.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miguelmariguin.tickets.entity.Show;

public interface IShowRepo extends JpaRepository<Show, Long> {
	@Query("SELECT s FROM Show s WHERE s.fechaInicio BETWEEN :fechaInicio AND :fechaFin")
    List<Show> buscarRegistrosEntreFechas(Date fechaInicio, Date fechaFin);

}