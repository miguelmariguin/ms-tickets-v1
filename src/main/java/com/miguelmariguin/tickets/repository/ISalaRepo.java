package com.miguelmariguin.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguelmariguin.tickets.entity.Sala;


public interface ISalaRepo extends JpaRepository<Sala,Long> {

}
