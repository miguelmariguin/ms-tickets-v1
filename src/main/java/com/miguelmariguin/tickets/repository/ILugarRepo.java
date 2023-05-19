package com.miguelmariguin.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguelmariguin.tickets.entity.Lugar;


public interface ILugarRepo extends JpaRepository<Lugar,Long>{

}
