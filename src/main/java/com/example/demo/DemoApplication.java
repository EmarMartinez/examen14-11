package com.example.demo;

import com.example.demo.application.ClienteServiceImpl;
import com.example.demo.controller.dto.ClienteInputDto;
import com.example.demo.domain.CabeceraFra;
import com.example.demo.domain.Cliente;
import com.example.demo.domain.LineasFra;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.LineaFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	LineaFraRepository lineaFraRepository;

	@Autowired
	ClienteServiceImpl clienteService;


	@PostConstruct
	public void inicio() {

		Cliente cliente = new Cliente(clienteService.addCliente(new ClienteInputDto("Emar")));

		CabeceraFra cabeceraFra = new CabeceraFra();

		LineasFra lineasFra1 = lineaFraRepository.save(new LineasFra("articulo1",2,100));
		LineasFra lineasFra2 = lineaFraRepository.save(new LineasFra("articulo2", 1, 250));

		cabeceraFra.setCliente(cliente);
		cabeceraFra.getLineas().add(lineasFra1);
		cabeceraFra.getLineas().add(lineasFra2);
		lineasFra1.setCabeceraFra(cabeceraFra);
		lineasFra2.setCabeceraFra(cabeceraFra);
		cliente.getFacturas().add(cabeceraFra);
		clienteRepository.save(cliente);

	}

}
