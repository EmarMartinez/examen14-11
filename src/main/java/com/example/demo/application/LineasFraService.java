package com.example.demo.application;

import com.example.demo.controller.dto.LineasFraInputDto;
import com.example.demo.controller.dto.LineasFraOutputDto;

import java.util.List;

public interface LineasFraService {
    void addLineaFactura(LineasFraInputDto lineasFraInputDto, int id);
    void addLineasFactura(List<LineasFraInputDto> lineasFraInputDtoList, int id);

    LineasFraOutputDto addLinea(LineasFraInputDto lineasFraInputDto);
}
