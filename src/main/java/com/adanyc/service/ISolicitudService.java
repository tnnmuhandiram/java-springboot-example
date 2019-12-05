package com.adanyc.service;

import java.util.List;

import com.adanyc.model.Solicitud;

public interface ISolicitudService {
	
	public abstract void llenarLista(); 
	
	public abstract List<Solicitud> listar();

	public abstract List<Solicitud> buscar(String ruc);

	public abstract String insertar(Solicitud s);
	
	public abstract String eliminar (String ruc);
	
	public abstract String editar (Solicitud s);
}
