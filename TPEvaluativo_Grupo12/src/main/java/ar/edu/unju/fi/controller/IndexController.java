package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.util.ListaCandidato;

@Controller
@RequestMapping("/mtvlatin")
public class IndexController {
	ListaCandidato listacandidatos = new ListaCandidato();

	@GetMapping("/inicio")
	public String getIndexPage(Model model) {
		model.addAttribute("candidato", listacandidatos.getCandidatos());
		return "index"; 
	}
	
}
