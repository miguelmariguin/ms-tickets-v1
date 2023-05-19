package com.miguelmariguin.tickets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.miguelmariguin.tickets.entity.Funcion;


public interface IFuncionRepo extends JpaRepository<Funcion,Long>{
	@Query(value = "SELECT f FROM Funcion f WHERE f.show.id = :show")
	List<Funcion> getFuncionByShow(@Param("show") Long show);
}
