package com.agence.carfleet.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.agence.carfleet.entities.Carro;
import com.agence.carfleet.entities.Empleado;
import com.agence.carfleet.entities.Viaje;
import com.agence.carfleet.exception.RestException;
import com.agence.carfleet.repositories.CarroRepository;
import com.agence.carfleet.repositories.EmpleadoRepository;
import com.agence.carfleet.repositories.ViajeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViajeService {
    private final ViajeRepository viajeRepository;
    private final EmpleadoRepository empleadoRepository;
    private final CarroRepository carroRepository;

    public List<Viaje> getAll() {
        return (List<Viaje>) viajeRepository.findAll();
    }

    public Optional<Viaje> getOne(int id) {
        return viajeRepository.findById(id);
    }

    public List<Viaje> getByFechaEntrega(int mes, int ano) {
        Date starDate = null;
        Date endDate = null;
        try {
            starDate = getDate(mes, ano);
            endDate = new Date(getDate(mes + 1, ano).getTime() - 1);
        } catch (Exception e) {
            throw new RestException(HttpStatus.BAD_REQUEST, e.getMessage());
        };
        return viajeRepository.findByFechaEntregaBetween(starDate, endDate);
    }

    public Viaje retirar(int idEmpleado, int idCarro) {
        Optional<Empleado> optionalEmpleado = empleadoRepository.findById(idEmpleado);
        Optional<Carro> optionalCarro = carroRepository.findById(idCarro);
        if (!optionalEmpleado.isPresent())
            throw new RestException(HttpStatus.BAD_REQUEST, "Empleado no existe");
        if (!optionalCarro.isPresent())
            throw new RestException(HttpStatus.BAD_REQUEST, "Carro no existe");
        Viaje viaje = new Viaje(optionalEmpleado.get(), optionalCarro.get());
        if (viajeRepository.existsByCarroAndFechaEntrega(viaje.getCarro(), null))
            throw new RestException(HttpStatus.BAD_REQUEST, "Carro ya retirado, no se puede volver a retirar");
        return viajeRepository.save(viaje);
    }

    public Viaje devolver(int idEmpleado, int idCarro) {
        Viaje viaje = new Viaje(idEmpleado, idCarro);
        Optional<Viaje> viajeOptional = viajeRepository.findByCarroAndFechaEntrega(viaje.getCarro(), null);
        if (viajeOptional.isPresent()) {
            viaje = viajeOptional.get();
            viaje.setFechaEntrega(new Date());
            return viajeRepository.save(viaje);
        }
        throw new RestException(HttpStatus.BAD_REQUEST, "No existe retiro registrado, no se puede devolver");
    }

    public Viaje create(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    public void delete(int id) {
        viajeRepository.deleteById(id);
    }

    private Date getDate(int mes, int ano) throws Exception {
        return new SimpleDateFormat("yyyy-MM-dd").parse(ano + "-" + mes + "-" + 1);
    }
}
