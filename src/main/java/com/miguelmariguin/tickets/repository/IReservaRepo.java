package com.miguelmariguin.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguelmariguin.tickets.entity.Reserva;

public interface IReservaRepo extends JpaRepository<Reserva,Long> {

}
