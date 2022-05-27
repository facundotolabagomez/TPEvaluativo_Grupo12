package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Usuario {
	private String nombre;
	private String email;
	private LocalDate fechaNacim;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacim() {
		return fechaNacim;
	}

	public void setFechaNacim(LocalDate fechaNacim) {
		this.fechaNacim = fechaNacim;
	}

	public Usuario(String nombre, String email, LocalDate fechaNacim) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.fechaNacim = fechaNacim;
	}
	
	

}
