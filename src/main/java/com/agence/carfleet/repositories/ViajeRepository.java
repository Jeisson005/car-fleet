package com.agence.carfleet.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agence.carfleet.entities.Carro;
import com.agence.carfleet.entities.Empleado;
import com.agence.carfleet.entities.Viaje;

public interface ViajeRepository extends JpaRepository<Viaje, Integer>{
    boolean existsByEmpleadoAndCarroAndFechaEntrega(Empleado empleado, Carro carro, Date fechaEntrega);
    Optional<Viaje> findByEmpleadoAndCarroAndFechaEntrega(Empleado empleado, Carro carro, Date fechaEntrega);
    List<Viaje> findByFechaEntregaBetween(Date startDate, Date endDate);
}
