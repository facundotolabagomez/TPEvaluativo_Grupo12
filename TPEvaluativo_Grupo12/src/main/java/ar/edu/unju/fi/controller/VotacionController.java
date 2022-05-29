package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.model.Candidato;
import ar.edu.unju.fi.util.ListaCandidato;

@Controller
@RequestMapping("/mtvlatin")
public class VotacionController {
	ListaCandidato listacandidatos = new ListaCandidato();
	private static final Log LOGGER = LogFactory.getLog(VotacionController.class);

	@GetMapping("/votacion")
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
			LOGGER.info("--"+listacandidatos.getCandidatos().get(i).getNombre()+listacandidatos.getCandidatos().get(i).getPorcentaje());
		}
		model.addAttribute("candidato", listacandidatos.getCandidatos());
		return "votacion";
	}
	
}
