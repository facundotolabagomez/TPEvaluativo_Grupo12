package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

//import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {
	@NotNull (message = "Debe completar el Nombre")
	@Size(min=3, max=20)
	private String nombre;
	@NotNull(message = "Debe completar el Email")
	@Email
	private String email;
	//@NotNull(message="Debe ingresar Fecha de Nacimiento")
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	//@Past (message = "La fecha debe ser anterior a la actual")
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
