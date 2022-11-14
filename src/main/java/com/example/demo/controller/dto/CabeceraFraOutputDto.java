package com.example.demo.controller.dto;

import com.example.demo.domain.CabeceraFra;
import com.example.demo.domain.LineasFra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CabeceraFraOutputDto {
    int id;
    double importeFra=0;
    ClienteOutputDto clienteOutputDto;
    List<LineasFraOutputDto> lineasFraOutputDtoList;

    public CabeceraFraOutputDto(CabeceraFra cabeceraFra) {
        List<Double> total = new ArrayList<>();
        this.id = cabeceraFra.getId();
        total = cabeceraFra.getLineas().stream().map(n->n.getCantidad() * n.getPrecio()).collect(Collectors.toList());
        double sum = 0;
        for (double i: total) {
            sum += i;
        }
        this.importeFra = sum;
        this.clienteOutputDto = cabeceraFra.getCliente().clienteToOutputDto();
        this.lineasFraOutputDtoList = cabeceraFra.getLineas().stream().map(LineasFra::lineasToLineasOutput).toList();
    }
}
