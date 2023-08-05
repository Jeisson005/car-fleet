package com.agence.carfleet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agence.carfleet.entities.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
    
}
