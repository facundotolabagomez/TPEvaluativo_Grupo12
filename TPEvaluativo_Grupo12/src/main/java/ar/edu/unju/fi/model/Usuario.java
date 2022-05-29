package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.time.Period;

public class Usuario {
	private String nombre;
	private String email;
	private LocalDate fechaNacim;
	private int votosuser;
	
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

	public Usuario(String nombre, String email, LocalDate fechaNacim, int votosuser) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.fechaNacim = fechaNacim;
		this.votosuser = votosuser;
	}

	public int obtenerEdad() {
		Period p = Period.between(this.fechaNacim, LocalDate.now());
		int anios = p.getYears();
		return anios;
	}

	public int getVotosuser() {
		return votosuser;
	}

	public void setVotosuser(int votosuser) {
		this.votosuser = votosuser;
	}
	
	

}
