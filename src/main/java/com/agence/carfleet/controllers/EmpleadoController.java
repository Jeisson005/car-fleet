package com.agence.carfleet.controllers;

import java.util.List;
import java.util.Optional;

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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @GetMapping()
    public List<Empleado> getAll() {
        return empleadoService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") int id) {
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
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.create(empleado));
        
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        empleadoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
