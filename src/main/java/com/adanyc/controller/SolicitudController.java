package com.adanyc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adanyc.model.Solicitud;
import com.adanyc.service.ISolicitudService;

@Controller
public class SolicitudController {

	@Autowired
	private ISolicitudService solicitudService;

	@RequestMapping(path = { "/index", "/" })
	public String listar(Model model, HttpServletRequest request) {
		// Artificio solo para llenar la lista por primera vez
		HttpSession session = request.getSession();
		String listaLlena = (String) session.getAttribute("listaLlena");
		if (listaLlena == null) {
			session.setAttribute("listaLlena", "S");
			solicitudService.llenarLista();
		}
		model.addAttribute("lista", solicitudService.listar());
		return "index";
	}

	@PostMapping(path = { "/buscar" })
	public String buscar(Model model, String ruc) {
		List<Solicitud> lista = solicitudService.buscar(ruc);
		model.addAttribute("lista", lista);
		model.addAttribute("ruc", ruc);
		return "index";
	}

	@GetMapping(path = { "/iniInsertar" })
	public String iniInsertar(Model model) {
		return "insertar";
	}

	@PostMapping(path = { "/insertar" })
	public String insertar(Model model, Solicitud s) {
		solicitudService.insertar(s);
		return "redirect:/";
	}

	@GetMapping(path = "/eliminar/{ruc}")
	public String eliminar(Model model, @PathVariable(name = "ruc") String ruc) {
		solicitudService.eliminar(ruc);
		return "redirect:/";
	}

	@GetMapping(path = "/iniEditar/{ruc}")
	public String iniEditar(Model model, @PathVariable(name = "ruc") String ruc) {
		List<Solicitud> lista = solicitudService.buscar(ruc);
		Solicitud obj = new Solicitud();
		for (Solicitud element : lista) {
			obj = element;
			break;
		}
		model.addAttribute("solicitud", obj);
		return "editar";
	}

	@PostMapping(path = "/editar")
	public String editar(Model model, Solicitud s) {
		solicitudService.editar(s);
		return "redirect:/";
	}
}
