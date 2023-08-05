package com.agence.carfleet.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agence.carfleet.entities.Empleado;
import com.agence.carfleet.models.Message;
import com.agence.carfleet.services.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping()
    public ArrayList<Empleado> getAll() {
        return empleadoService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Integer id) {
        Optional<Empleado> empleado = empleadoService.getOne(id);
        if (empleado.isPresent())
            return ResponseEntity.ok(empleado);
        else {
            Message msg = new Message("Element with id " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Empleado empleado) {
        return ResponseEntity.ok(empleadoService.create(empleado));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.noContent().build();
    }

}
