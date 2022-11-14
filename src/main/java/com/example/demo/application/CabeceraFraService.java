package com.example.demo.application;


import com.example.demo.controller.dto.CabeceraFraOutputDto;
import com.example.demo.controller.dto.LineasFraInputDto;

import java.util.List;

public interface CabeceraFraService {

    List<CabeceraFraOutputDto> getFacturas();
    void deleteFactura(int id);

    CabeceraFraOutputDto addLineaFactura(LineasFraInputDto lineasFraInputDto, int id);
}
