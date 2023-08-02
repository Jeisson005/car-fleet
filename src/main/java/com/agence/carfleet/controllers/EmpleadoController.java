package com.agence.carfleet.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agence.carfleet.entities.Empleado;
import com.agence.carfleet.services.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping()
    public ArrayList<Empleado> getAll(){
        return empleadoService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Empleado> getOne(@PathVariable("id") Integer id){
        return empleadoService.getOne(id);
    }

    @PostMapping()
    public Empleado create(@RequestBody Empleado empleado){
        return empleadoService.create(empleado);
    }
    
}
