package com.agence.carfleet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agence.carfleet.entities.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer>{
    
}
