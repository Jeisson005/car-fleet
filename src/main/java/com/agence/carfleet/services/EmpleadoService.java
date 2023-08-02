package com.agence.carfleet.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agence.carfleet.entities.Empleado;
import com.agence.carfleet.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public ArrayList<Empleado> getAll(){
        return (ArrayList<Empleado>) empleadoRepository.findAll();
    }

    public Optional<Empleado> getOne(Integer id){
        return empleadoRepository.findById(id);
    }

    public Empleado create(Empleado empleado){
        return empleadoRepository.save(empleado);
    }
}
