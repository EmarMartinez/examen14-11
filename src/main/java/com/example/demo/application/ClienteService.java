package com.example.demo.application;

import com.example.demo.controller.dto.ClienteInputDto;
import com.example.demo.controller.dto.ClienteOutputDto;
import com.example.demo.domain.CabeceraFra;

public interface ClienteService {
    ClienteOutputDto addCliente(ClienteInputDto clienteInputDto);
    void deleteClienteById(int id);
    ClienteOutputDto getClienteById(int id);

}
