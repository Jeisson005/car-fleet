package com.agence.carfleet.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "carro")
@NoArgsConstructor
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank()
    @Column(nullable = false)
    private String modelo;
    @NotBlank()
    @Column(nullable = false)
    private String marca;
    @NotNull()
    @Column(name = "fecha_fabricacion", nullable = false)
    private Date fechaFabricacion;

    public Carro(int id) {
        this.id = id;
    }
}
