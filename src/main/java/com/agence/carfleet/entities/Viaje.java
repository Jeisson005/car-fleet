package com.agence.carfleet.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "viaje")
@NoArgsConstructor
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fecha_retirada")
    private Date fechaRetirada;
    @Column(name = "fecha_entrega")
    private Date fechaEntrega;
    
    @ManyToOne
    @JoinColumn (name = "empleado_id")
    private Empleado empleado;
    @ManyToOne
    @JoinColumn (name = "carro_id")
    private Carro carro;

    public Viaje(int idEmpleado, int idCarro) {
        this.empleado = new Empleado(idEmpleado);
        this.carro = new Carro(idCarro);
        this.fechaRetirada = new Date();
    }
}
