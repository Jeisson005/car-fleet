package com.agence.carfleet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agence.carfleet.entities.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
    
}
