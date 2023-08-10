package com.agence.carfleet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.agence.carfleet.entities.Carro;
import com.agence.carfleet.exception.RestException;
import com.agence.carfleet.repositories.CarroRepository;
import com.agence.carfleet.repositories.ViajeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarroService {
    private final CarroRepository carroRepository;
    private final ViajeRepository viajeRepository;

    public List<Carro> getAll() {
        return (List<Carro>) carroRepository.findAll();
    }

    public Optional<Carro> getOne(int id) {
        return carroRepository.findById(id);
    }

    public List<Carro> getRetirados() {
        return viajeRepository.findCarrosWithFechaEntregaNull();
    }

    public Carro create(Carro carro) {
        return carroRepository.save(carro);
    }

    public Carro update(Carro carro) {
        Optional<Carro> optionalCarro = carroRepository.findById(carro.getId());
        if(optionalCarro.isPresent())
            return carroRepository.save(carro);
        throw new RestException(HttpStatus.BAD_REQUEST, "Registro inexistente");
    }

    public void delete(int id) {
        carroRepository.deleteById(id);
    }
}
