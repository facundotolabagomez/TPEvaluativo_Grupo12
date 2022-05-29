package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.util.ListaUsuario;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);
	ListaUsuario listausuarios= new ListaUsuario();
	
	@GetMapping("/lista")
	public String getListaPage(Model model) {
		model.addAttribute("usuario", listausuarios.getUsuarios());
		return "lista_usuarios"; 
	}
	
	
	
	@GetMapping("/registro")
	public String getRegistroPage(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "verificacion_usuario";
	}
	
	
	
	@GetMapping("/verif")
	public ModelAndView verificarDatosUsuario(@Validated @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult ) {
		
		boolean band = false;
		String valor = "";
		ModelAndView mav = new ModelAndView("");
		
		//for(Usuario user : listausuarios.getUsuarios()) {
		for(int i=0;i<listausuarios.getUsuarios().size();i++) {
			//if(user.getEmail().equals(usuario.getEmail())) {
			if(listausuarios.getUsuarios().get(i).getEmail().equals(usuario.getEmail())) {
				LOGGER.info("usuario aceptado");
				int cantidadvotos = listausuarios.getUsuarios().get(i).getVotosuser();
				if (cantidadvotos<3) {
					listausuarios.getUsuarios().get(i).setVotosuser(cantidadvotos+1);
					LOGGER.info(listausuarios.getUsuarios().get(i).getEmail()+" votó "+listausuarios.getUsuarios().get(i).getVotosuser()+" veces");
					valor="redirect:/votacion/lista";
					mav.addObject("usuario", usuario);
					band=true;
				}else {
					valor="redirect:/votacion/fail";
				}
			}
		}
		if (!band) {
			valor = "redirect:/votacion/noexiste";
			LOGGER.info("usuario denegado");
		}
		
		//primero revisa si existe el usuario
		//revisa que no tengas mas de 3 votos
		//agregar un voto y redireccionar a lista votacion
		ModelAndView mavVerif = new ModelAndView(valor);
		return mavVerif;
	}
	
}
