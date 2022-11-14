package com.example.demo.application;

import com.example.demo.controller.dto.LineasFraInputDto;
import com.example.demo.controller.dto.LineasFraOutputDto;
import com.example.demo.domain.CabeceraFra;
import com.example.demo.domain.LineasFra;
import com.example.demo.repository.CabeceraFraRepository;
import com.example.demo.repository.LineaFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineasFraServiceImpl implements LineasFraService{
    @Autowired
    LineaFraRepository lineaFraRepository;
    @Autowired
    CabeceraFraRepository cabeceraFraRepository;

    @Override
    public void addLineaFactura(LineasFraInputDto lineasFraInputDto, int id) {
        CabeceraFra cabeceraFra = cabeceraFraRepository.findById(id).orElseThrow();
        cabeceraFra.getLineas().add(new LineasFra(lineasFraInputDto));
        cabeceraFraRepository.save(cabeceraFra);
    }

    @Override
    public void addLineasFactura(List<LineasFraInputDto> lineasFraInputDtoList, int id) {
        CabeceraFra cabeceraFra = cabeceraFraRepository.findById(id).orElseThrow();
        lineasFraInputDtoList.stream().map(n->cabeceraFra.getLineas().add(new LineasFra(n)));
        cabeceraFraRepository.save(cabeceraFra);
    }

    @Override
    public LineasFraOutputDto addLinea(LineasFraInputDto lineasFraInputDto) {
        LineasFra lineasFra = new LineasFra(lineasFraInputDto);
        return lineaFraRepository.save(lineasFra).lineasToLineasOutput();
    }
}
