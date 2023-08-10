package com.agence.carfleet.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agence.carfleet.entities.Carro;
import com.agence.carfleet.entities.Viaje;

public interface ViajeRepository extends JpaRepository<Viaje, Integer>{
    boolean existsByCarroAndFechaEntrega(Carro carro, Date fechaEntrega);
    Optional<Viaje> findByCarroAndFechaEntrega(Carro carro, Date fechaEntrega);
    List<Viaje> findByFechaEntregaBetween(Date startDate, Date endDate);
    @Query("SELECT v.carro FROM Viaje v WHERE v.fechaEntrega IS NULL")
    List<Carro> findCarrosWithFechaEntregaNull();
}
