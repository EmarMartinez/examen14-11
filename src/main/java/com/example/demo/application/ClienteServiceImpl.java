package com.example.demo.application;

import com.example.demo.controller.dto.ClienteInputDto;
import com.example.demo.controller.dto.ClienteOutputDto;
import com.example.demo.domain.CabeceraFra;
import com.example.demo.domain.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements  ClienteService{
    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public ClienteOutputDto addCliente(ClienteInputDto clienteInputDto) {
       return clienteRepository.save(new Cliente(clienteInputDto)).clienteToOutputDto();
    }

    @Override
    public void deleteClienteById(int id) {
        clienteRepository.findById(id).orElseThrow();
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteOutputDto getClienteById(int id) {
        return clienteRepository.findById(id).orElseThrow().clienteToOutputDto();
    }

}
