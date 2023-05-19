package com.miguelmariguin.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguelmariguin.tickets.entity.Butaca;


public interface IButacaRepo extends JpaRepository<Butaca,Long> {

}
