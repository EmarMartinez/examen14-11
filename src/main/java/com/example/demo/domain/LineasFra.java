package com.example.demo.domain;

import com.example.demo.controller.dto.LineasFraInputDto;
import com.example.demo.controller.dto.LineasFraOutputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LineasFra {
    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    CabeceraFra cabeceraFra;

    @Column(nullable = false)
    String proNombb;

    double cantidad;
    double precio;

    public LineasFra(String nombre, double cantidad, double precio) {
        this.proNombb = nombre;
        this.cantidad=cantidad;
        this.precio=precio;
    }

    public LineasFra(LineasFraInputDto lineasFraInputDto) {
        this.proNombb=lineasFraInputDto.getNombre();
        this.cantidad=lineasFraInputDto.getCantidad();
        this.precio=lineasFraInputDto.getPrecio();
    }

    public LineasFraOutputDto lineasToLineasOutput() {
        return new LineasFraOutputDto(this.id, this.proNombb, this.cantidad, this.precio);
    }


}
