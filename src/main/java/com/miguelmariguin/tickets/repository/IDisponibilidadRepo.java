package com.miguelmariguin.tickets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.miguelmariguin.tickets.entity.Disponibilidad;

public interface IDisponibilidadRepo extends JpaRepository<Disponibilidad,Long> {
	@Query(value = "SELECT d FROM Disponibilidad d WHERE d.funcion.id = :funcion")
	List<Disponibilidad> getDisponibilidadByFuncion(@Param("funcion") Long funcion);
	
	@Query(value = "SELECT d FROM Disponibilidad d WHERE d.funcion.id = :funcion AND d.reserva=null")
	List<Disponibilidad> getDisponibilidadNullByFuncion(@Param("funcion") Long funcion);
	
	@Query("SELECT d FROM Disponibilidad d WHERE d.precio BETWEEN :min AND :max")
    List<Disponibilidad> getDisponibilidadByPrecio(Float min, Float max);
}
