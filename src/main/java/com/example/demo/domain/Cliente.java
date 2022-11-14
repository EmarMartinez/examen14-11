package com.example.demo.domain;


import com.example.demo.controller.dto.ClienteInputDto;
import com.example.demo.controller.dto.ClienteOutputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue
    int id;
    @Column(nullable = false, length = 100)
    String nombre;

    @OneToMany(cascade = ALL, mappedBy = "cliente")
    List<CabeceraFra> facturas = new ArrayList<>();

    public Cliente (String nombre) {
        this.nombre = nombre;
    }

    public Cliente(ClienteInputDto clienteInputDto) {
        this.nombre=clienteInputDto.getNombre();
    }

    public ClienteOutputDto clienteToOutputDto() {
        return new ClienteOutputDto(this.id,this.nombre);
    }

    public Cliente(ClienteOutputDto clienteOutputDto) {
        this.id = clienteOutputDto.getId();
        this.nombre = clienteOutputDto.getNombre();

    }
}
