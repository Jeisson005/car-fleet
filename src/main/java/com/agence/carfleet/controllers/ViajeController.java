package com.agence.carfleet.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agence.carfleet.entities.Viaje;
import com.agence.carfleet.models.Message;
import com.agence.carfleet.services.ViajeService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/viajes")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class ViajeController {
    private final ViajeService viajeService;

    @GetMapping()
    public List<Viaje> getAll() {
        return viajeService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getOne(@Valid @PathVariable("id") int id) {
        Optional<Viaje> viaje = viajeService.getOne(id);
        if (viaje.isPresent())
            return ResponseEntity.ok(viaje);
        else {
            Message msg = new Message("Element with id " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }

    @GetMapping(path = "/realizados/{mes}/{ano}")
    public ResponseEntity<?> getOneByFechaEntrega(@Valid @PathVariable("mes") int mes, @Valid @PathVariable("ano") int ano) {
        return ResponseEntity.ok(viajeService.getByFechaEntrega(mes, ano));
    }

    @PostMapping(path = "/{idEmpleado}/{idCarro}")
    public ResponseEntity<?> create(@Valid @PathVariable("idEmpleado") int idEmpleado,
            @Valid @PathVariable("idCarro") int idCarro) {
        Viaje viaje = viajeService.retirar(idEmpleado, idCarro);
        return ResponseEntity.ok(viaje);
    }

    @DeleteMapping(path = "/{idEmpleado}/{idCarro}")
    public ResponseEntity<?> delete(@Valid @PathVariable("idEmpleado") int idEmpleado,
            @Valid @PathVariable("idCarro") int idCarro) {
        Viaje viaje = viajeService.devolver(idEmpleado, idCarro);
        return ResponseEntity.ok(viaje);
    }

}
