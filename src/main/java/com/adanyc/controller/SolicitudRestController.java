package com.adanyc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adanyc.model.Solicitud;
import com.adanyc.service.ISolicitudService;

@RestController
@RequestMapping("/solicitud/api/v1")
public class SolicitudRestController {

	@Autowired
	private ISolicitudService solicitudService;

	@RequestMapping(path = "/solicitudes")
	public ResponseEntity<List<Solicitud>> solicitudes() {
		List<Solicitud> lista = solicitudService.listar();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping(path = "/buscar/{ruc}")
	public ResponseEntity<List<Solicitud>> buscar(
			@PathVariable(name = "ruc", required = true) String ruc) {
		List<Solicitud> lista = solicitudService.buscar(ruc);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
}
