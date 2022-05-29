package ar.edu.unju.fi.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Candidato;
import ar.edu.unju.fi.util.ListaCandidato;


@Controller
@RequestMapping("/candidato")
public class CandidatoController {
	
	ListaCandidato listacandidatos = new ListaCandidato();
	private static final Log LOGGER = LogFactory.getLog(CandidatoController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoCandidatoPage(Model model) {
		model.addAttribute("candidato", new Candidato());
		return "nuevo_candidato";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaCandidatosPage(@Validated @ModelAttribute("candidato")Candidato candidato, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");

			ModelAndView mav = new ModelAndView("nuevo_candidato");
			mav.addObject("candidato", candidato);
			return mav;
			
		}
		ModelAndView mavCandidato = new ModelAndView("lista_candidatos");
		if (listacandidatos.getCandidatos().add(candidato)) {
			LOGGER.info("Se agregó Candidato");
		}
		mavCandidato.addObject("candidato", listacandidatos.getCandidatos());
		return mavCandidato; 
	}
	
	@GetMapping("/listaCandidatos")
	public String getListaCandidatosPage(Model model) {
		model.addAttribute("candidato", listacandidatos.getCandidatos());
		return "lista_candidatos";
	}
	
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarCandidatoPage(@PathVariable(value="codigo")int codigo) {
		ModelAndView mav = new ModelAndView("edicion_candidato");
		Optional<Candidato> candidato = listacandidatos.getCandidatos().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		mav.addObject("candidato", candidato);
		return mav;
	}
	
	
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView getEliminarCandidatoPage(@PathVariable(value = "codigo") int codigo) {
		ModelAndView mavCandidato = new ModelAndView("lista_candidatos");
		for (int i = listacandidatos.getCandidatos().size(); i > 0; i--) {
			//if (can.getCodigo() == codigo) {
			if (listacandidatos.getCandidatos().get(i-1).getCodigo() == codigo) {
				LOGGER.info("Se elimino Candidato");
				listacandidatos.getCandidatos().remove(i-1);
			}
		}
		mavCandidato.addObject("candidato", listacandidatos.getCandidatos());
		return mavCandidato;
	}
	
	
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosCandidato(@Validated @ModelAttribute("candidato") Candidato candidato, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+candidato);
			ModelAndView mav = new ModelAndView("edicion_candidato");
			mav.addObject("candidato", candidato);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("lista_candidatos");
		for(Candidato candid : listacandidatos.getCandidatos()) {
			if(candid.getCodigo() == candidato.getCodigo()) {
				candid.setNombre(candidato.getNombre());
				candid.setGenero(candidato.getGenero());
				candid.setDescripcion(candidato.getDescripcion());
				candid.setCantVotos(candidato.getCantVotos());
			}
			mav.addObject("candidato", candid);
		}
		mav.addObject("candidato", listacandidatos.getCandidatos());
		
		return mav;
		
	}
	
	
	
}
