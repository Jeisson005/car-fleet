package com.agence.carfleet.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.agence.carfleet.entities.Viaje;
import com.agence.carfleet.repositories.ViajeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViajeService {
    private final ViajeRepository viajeRepository;

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
        } catch (ParseException e) {
            // TODO: Fecha no valida
            e.printStackTrace();
        };
        return viajeRepository.findByFechaEntregaBetween(starDate, endDate);
    }

    public Viaje retirar(int idEmpleado, int idCarro) {
        Viaje viaje = new Viaje(idEmpleado, idCarro);
        if (!viajeRepository.existsByEmpleadoAndCarroAndFechaEntrega(viaje.getEmpleado(), viaje.getCarro(), null))
            return viajeRepository.save(viaje);
        return viajeRepository.save(viaje); // TODO: Error
    }

    public Viaje devolver(int idEmpleado, int idCarro) {
        Viaje viaje = new Viaje(idEmpleado, idCarro);
        Optional<Viaje> viajeOptional = viajeRepository.findByEmpleadoAndCarroAndFechaEntrega(viaje.getEmpleado(),
                viaje.getCarro(), null);
        if (viajeOptional.isPresent()) {
            viaje = viajeOptional.get();
            viaje.setFechaEntrega(new Date());
            return viajeRepository.save(viaje);
        }
        return viajeRepository.save(viaje); // TODO: Error
    }

    public Viaje create(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    public void delete(int id) {
        viajeRepository.deleteById(id);
    }

    private Date getDate(int mes, int ano) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(ano + "-" + mes + "-" + 1);
    }
}
