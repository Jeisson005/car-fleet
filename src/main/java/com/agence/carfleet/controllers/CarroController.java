package com.agence.carfleet.controllers;

import java.util.ArrayList;
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

import com.agence.carfleet.entities.Carro;
import com.agence.carfleet.models.Message;
import com.agence.carfleet.services.CarroService;
import com.agence.carfleet.services.ViajeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/carros")
@RequiredArgsConstructor
public class CarroController {
    private final CarroService carroService;
    // private final ViajeService viajeService;

    @GetMapping()
    public ArrayList<Carro> getAll() {
        return carroService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") int id) {
        Optional<Carro> carro = carroService.getOne(id);
        if (carro.isPresent())
            return ResponseEntity.ok(carro);
        else {
            Message msg = new Message("Element with id " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Carro carro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carroService.create(carro));
        
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        carroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
