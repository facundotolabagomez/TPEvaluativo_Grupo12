package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.model.Candidato;
import ar.edu.unju.fi.service.ICandidatoService;
import ar.edu.unju.fi.util.ListaCandidato;

@Controller
@RequestMapping("/votacion")
public class VotacionController {
	
	@Autowired
	@Qualifier("AlumnoServiceImpLista")
	private ICandidatoService candidatoServiceVot;
	
	//ListaCandidato listacandidatos = new ListaCandidato();
	private static final Log LOGGER = LogFactory.getLog(VotacionController.class);

	
	@GetMapping("/lista")
	public String getVotacionPage(Model model) {
		/*LOGGER.info("PORCENTAJE OK");
		model.addAttribute("candidato", candidatoServiceVot.obtenerPorcentajes());
		return "lista_votacion";*/
		candidatoServiceVot.obtenerPorcentajes();
		model.addAttribute("candidato", candidatoServiceVot.getListaCandidato().getCandidatos());
		return "lista_votacion";
	}
	
	@GetMapping("/votar/{codigo}")
	public String getVotarPage(@PathVariable(value="codigo")int codigo) {
		LOGGER.info("CODIGO--------->"+codigo);
		candidatoServiceVot.votar(codigo);
		return "redirect:/votacion/gracias";
	}
	
	@GetMapping("/gracias")
	public String getGraciasPage(Model model) {		
		return "gracias";
	}
	
	@GetMapping("/fail")
	public String getLimitePage(Model model) {		
		return "limite";
	}
	
	@GetMapping("/noexiste")
	public String getNouserPage(Model model) {		
		return "nouser";
	}
	
	@GetMapping("/mostrar")
	public String getMostrarPage(Model model) {
		LOGGER.info("PORCENTAJE OK");
		candidatoServiceVot.obtenerPorcentajes();
		model.addAttribute("candidato", candidatoServiceVot.getListaCandidato().getCandidatos());
		return "mostrar_votacion";
	}
}
	

