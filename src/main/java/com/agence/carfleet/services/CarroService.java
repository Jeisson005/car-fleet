package com.agence.carfleet.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agence.carfleet.entities.Carro;
import com.agence.carfleet.repositories.CarroRepository;

@Service
public class CarroService {
    @Autowired
    CarroRepository carroRepository;

    public ArrayList<Carro> getAll() {
        return (ArrayList<Carro>) carroRepository.findAll();
    }

    public Optional<Carro> getOne(int id) {
        return carroRepository.findById(id);
    }

    public Carro create(Carro carro) {
        return carroRepository.save(carro);
    }

    public void delete(int id) {
        carroRepository.deleteById(id);
    }
}
