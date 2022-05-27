package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unju.fi.model.Usuario;

public class ListaUsuario {
	private ArrayList<Usuario> usuarios;
	
	public ListaUsuario() {
		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Facu","facu@gmail.com",LocalDate.of(1992, 03, 12)));
		usuarios.add(new Usuario("Elio","elio@gmail.com",LocalDate.of(1991, 01, 01)));
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}
	