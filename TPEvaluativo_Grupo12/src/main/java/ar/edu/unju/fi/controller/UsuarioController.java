package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ar.edu.unju.fi.util.ListaUsuario;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	ListaUsuario listausuarios= new ListaUsuario();
	
	@GetMapping("/lista")
	public String getIndexPage(Model model) {
		model.addAttribute("usuario", listausuarios.getUsuarios());
		return "lista_usuarios"; 
	}
}
