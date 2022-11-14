package com.example.demo.controller;

import com.example.demo.application.CabeceraFraServiceImpl;
import com.example.demo.controller.dto.CabeceraFraOutputDto;
import com.example.demo.controller.dto.LineasFraInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("factura")
public class Controller {

    @Autowired
    CabeceraFraServiceImpl cabeceraFraService;


    @GetMapping
    public List<CabeceraFraOutputDto> getFacturas() {
        return cabeceraFraService.getFacturas();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFacturaById(@PathVariable int id) {

        try {
            cabeceraFraService.deleteFactura(id);
            return ResponseEntity.ok().body("La factura con id:" + id + " ha sido borrada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id no encontrada");
        }
    }
    @PostMapping("/linea/{id}")
    public ResponseEntity<CabeceraFraOutputDto> addLineaFactura(@RequestBody LineasFraInputDto lineasFraInputDto, @PathVariable int id) {
        try {
            return ResponseEntity.ok().body(cabeceraFraService.addLineaFactura(lineasFraInputDto, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
