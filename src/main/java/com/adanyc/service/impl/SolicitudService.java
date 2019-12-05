package com.adanyc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanyc.model.Solicitud;
import com.adanyc.repo.SolicitudRepo;
import com.adanyc.service.ISolicitudService;

@Service
public class SolicitudService implements ISolicitudService {

	@Autowired
	private SolicitudRepo solicitudRepo;

	@Override
	public List<Solicitud> listar() {
		return solicitudRepo.listar();
	}

	@Override
	public List<Solicitud> buscar(String ruc) {
		return solicitudRepo.buscar(ruc);
	}

	@Override
	public String insertar(Solicitud s) {
		return solicitudRepo.insertar(s);
	}

	@Override
	public String eliminar(String ruc) {
		return solicitudRepo.eliminar(ruc);
	}

	@Override
	public String editar(Solicitud s) {
		return solicitudRepo.editar(s);
	}

	@Override
	public void llenarLista() {
		solicitudRepo.llenarLista();		
	}

}
