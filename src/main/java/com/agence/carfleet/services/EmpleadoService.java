package com.agence.carfleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.agence.carfleet.entities.Empleado;
import com.agence.carfleet.repositories.EmpleadoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public List<Empleado> getAll() {
        return (List<Empleado>) empleadoRepository.findAll();
    }

    public Optional<Empleado> getOne(int id) {
        return empleadoRepository.findById(id);
    }

    public Empleado create(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void delete(int id) {
        empleadoRepository.deleteById(id);
    }
}
