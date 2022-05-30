package ar.edu.unju.fi.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
public class Candidato {
	@Min(value=1, message="El valor mínimo es 1") 
	@Max(value=9999,message="El valor máximo permitido es 9999")
	private int codigo;
	@NotNull (message = "Debe completar el Nombre")
	@Size(min=3, max=20)
	private String nombre;
	@NotNull (message = "Debe completar el Genero")
	@Size(min=3, max=10)
	private String genero;
	@NotNull (message = "Debe completar la Descripcion")
	@Size(min=3, max=25)
	private String descripcion;
	private int cantVotos;
	private double porcentaje;
	
	public Candidato() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantVotos() {
		return cantVotos;
	}

	public void setCantVotos(int cantVotos) {
		this.cantVotos = cantVotos;
	}

	public Candidato(int codigo, String nombre, String genero, String descripcion, int cantVotos, double porcentaje) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.genero = genero;
		this.descripcion = descripcion;
		this.cantVotos = cantVotos;
		this.porcentaje = porcentaje;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	

}
