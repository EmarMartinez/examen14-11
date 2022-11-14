package com.example.demo.application;

import com.example.demo.controller.dto.CabeceraFraOutputDto;
import com.example.demo.controller.dto.LineasFraInputDto;
import com.example.demo.domain.CabeceraFra;
import com.example.demo.repository.CabeceraFraRepository;
import com.example.demo.repository.LineaFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabeceraFraServiceImpl implements CabeceraFraService{

    @Autowired
    CabeceraFraRepository cabeceraFraRepository;
    @Autowired
    LineaFraRepository lineaFraRepository;
    @Autowired
    LineasFraServiceImpl lineasFraService;

    @Override
    public List<CabeceraFraOutputDto> getFacturas() {

        List<CabeceraFra> lista = cabeceraFraRepository.findAll();
        lista.forEach(n->n.setLineas(lineaFraRepository.findAllByCabeceraFraId(n.getId())));
        return cabeceraFraRepository.findAll().stream().map(CabeceraFraOutputDto::new).toList();
    }

    @Override
    public void deleteFactura(int id) {
        cabeceraFraRepository.findById(id).orElseThrow();
        cabeceraFraRepository.deleteById(id);
    }

    @Override
    public CabeceraFraOutputDto addLineaFactura(LineasFraInputDto lineasFraInputDto, int id) {

        lineasFraService.addLineaFactura(lineasFraInputDto,id);
        return new CabeceraFraOutputDto(cabeceraFraRepository.findById(id).orElseThrow());
    }
}
