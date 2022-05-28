package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.util.ListaCandidato;

@Controller
@RequestMapping("/mtvlatin")
public class VotacionController {
	ListaCandidato listacandidatos = new ListaCandidato();

	@GetMapping("/votacion")
	public String getVotacionPage(Model model) {
		model.addAttribute("candidato", listacandidatos.getCandidatos());
		return "votacion"; 
	}
	
}
