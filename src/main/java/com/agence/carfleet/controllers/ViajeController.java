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

import com.agence.carfleet.entities.Viaje;
import com.agence.carfleet.models.Message;
import com.agence.carfleet.services.ViajeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/viajes")
@RequiredArgsConstructor
public class ViajeController {
    private final ViajeService viajeService;

    @GetMapping()
    public ArrayList<Viaje> getAll() {
        return viajeService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") int id) {
        Optional<Viaje> viaje = viajeService.getOne(id);
        if (viaje.isPresent())
            return ResponseEntity.ok(viaje);
        else {
            Message msg = new Message("Element with id " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }

    @GetMapping(path = "/realizadas/{mes}/{ano}")
    public ResponseEntity<?> getOneByFechaEntrega(@PathVariable("mes") int mes, @PathVariable("ano") int ano) {
        return ResponseEntity.ok(viajeService.getByFechaEntrega(mes, ano));
    }

    @PostMapping(path = "/{idEmpleado}/{idCarro}")
    public ResponseEntity<?> create(@PathVariable("idEmpleado") int idEmpleado,
            @PathVariable("idCarro") int idCarro) {
        Viaje viaje = viajeService.retirar(idEmpleado, idCarro);
        return ResponseEntity.ok(viaje);
    }

    @DeleteMapping(path = "/{idEmpleado}/{idCarro}")
    public ResponseEntity<?> delete(@PathVariable("idEmpleado") int idEmpleado,
            @PathVariable("idCarro") int idCarro) {
        Viaje viaje = viajeService.devolver(idEmpleado, idCarro);
        return ResponseEntity.ok(viaje);
    }

}
