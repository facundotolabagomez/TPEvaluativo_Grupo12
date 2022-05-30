package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.model.Candidato;

import ar.edu.unju.fi.util.ListaCandidato;

@Controller
@RequestMapping("/votacion")
public class VotacionController {
	ListaCandidato listacandidatos = new ListaCandidato();
	private static final Log LOGGER = LogFactory.getLog(VotacionController.class);

	
	@GetMapping("/lista")
	public String getVotacionPage(Model model) {
		int totalvotos=0;
		double porcentaje=0;
		for(Candidato candid : listacandidatos.getCandidatos()) {
			totalvotos=totalvotos+candid.getCantVotos();
		}
		for(int i=0;i<listacandidatos.getCandidatos().size();i++) {
			int votoindividual = listacandidatos.getCandidatos().get(i).getCantVotos();
			porcentaje=((100.0*votoindividual)/totalvotos);
			listacandidatos.getCandidatos().get(i).setPorcentaje(porcentaje);
			LOGGER.info("CANDIDATO-> "+listacandidatos.getCandidatos().get(i).getNombre()+" PORCENTAJE-> "+listacandidatos.getCandidatos().get(i).getPorcentaje());
		}
		model.addAttribute("candidato", listacandidatos.getCandidatos());
		return "lista_votacion";
	}
	
	@GetMapping("/votar/{codigo}")
	public String getVotarPage(@PathVariable(value="codigo")int codigo) {
		LOGGER.info("CODIGO--------->"+codigo);
		for(int i=0;i<listacandidatos.getCandidatos().size();i++) {
			if(listacandidatos.getCandidatos().get(i).getCodigo() == codigo) {
				int cantvotos = listacandidatos.getCandidatos().get(i).getCantVotos();
				listacandidatos.getCandidatos().get(i).setCantVotos(cantvotos+1);
			}
		}
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
		int totalvotos=0;
		double porcentaje=0;
		for(Candidato candid : listacandidatos.getCandidatos()) {
			totalvotos=totalvotos+candid.getCantVotos();
		}
		for(int i=0;i<listacandidatos.getCandidatos().size();i++) {
			int votoindividual = listacandidatos.getCandidatos().get(i).getCantVotos();
			porcentaje=((100.0*votoindividual)/totalvotos);
			listacandidatos.getCandidatos().get(i).setPorcentaje(porcentaje);
			LOGGER.info("CANDIDATO-> "+listacandidatos.getCandidatos().get(i).getNombre()+" PORCENTAJE-> "+listacandidatos.getCandidatos().get(i).getPorcentaje());
		}
		model.addAttribute("candidato", listacandidatos.getCandidatos());
		return "mostrar_votacion";
	}
}
	

