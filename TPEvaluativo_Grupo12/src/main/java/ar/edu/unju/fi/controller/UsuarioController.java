package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		return "registro_usuario";
	}
	
	
	
	@GetMapping("/verif")
	public ModelAndView verificarDatosUsuario(@ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult ) {
		
		LOGGER.info("llegamos aqui");
		boolean band = false;
		String valor = "";
		ModelAndView mav = new ModelAndView(valor);
		LOGGER.info("Valor--> "+valor);
		
		for(Usuario user : listausuarios.getUsuarios()) {
			if(user.getEmail() == usuario.getEmail()) {
				valor = "votacion";
				mav.addObject("usuario", user);
				band=true;
				LOGGER.info("usuario aceptado");
			}
		}
		if (!band) {
			valor = "registro_usuario";
			mav.addObject("usuario", usuario);
			LOGGER.info("usuario denegado");
		}
		return mav;
	}
	
}
