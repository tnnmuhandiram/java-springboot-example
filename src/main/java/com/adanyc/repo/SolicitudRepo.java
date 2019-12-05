package com.adanyc.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.adanyc.model.Solicitud;

@Repository
public class SolicitudRepo {

	private List<Solicitud> lista = new ArrayList<Solicitud>();

	public void llenarLista() {
		Solicitud s = new Solicitud();
		// 1
		s.setRuc("12345678912");
		s.setCodigoSolicitud("ABC123456");
		s.setFechaSolicitud("16-10-2019");
		lista.add(s);
		// 2
		s = new Solicitud();
		s.setRuc("14725836914");
		s.setCodigoSolicitud("DEF123456");
		s.setFechaSolicitud("17-10-2019");
		lista.add(s);
		// 3
		s = new Solicitud();
		s.setRuc("16925814714");
		s.setCodigoSolicitud("GHI123456");
		s.setFechaSolicitud("16-10-2019");
		lista.add(s);
	}

	public List<Solicitud> listar() {
		return lista;
	}

	public List<Solicitud> buscar(String ruc) {
		return lista.stream().filter(x -> x.getRuc().startsWith(ruc)).collect(Collectors.toList());
	}

	public String insertar(Solicitud s) {
		Solicitud obj = new Solicitud();
		obj.setRuc(s.getRuc());
		obj.setCodigoSolicitud(s.getCodigoSolicitud());
		obj.setFechaSolicitud(s.getFechaSolicitud());
		lista.add(obj);
		return null;
	}

	public String eliminar(String ruc) {
		lista.removeIf(x -> x.getRuc().equals(ruc));
		return null;
	}

	public String editar(Solicitud solicitud) {
		int indice = 0;
		String ruc = "";
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getRuc().equals(solicitud.getRuc())) {
				ruc = solicitud.getRuc();
				indice = i;
				break;
			}
		}

		Solicitud s = new Solicitud();
		s.setRuc(ruc);
		s.setCodigoSolicitud(solicitud.getCodigoSolicitud());
		s.setFechaSolicitud(solicitud.getFechaSolicitud());
		lista.set(indice, s);

		return null;
	}
}
