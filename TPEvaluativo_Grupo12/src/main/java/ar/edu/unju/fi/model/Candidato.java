package ar.edu.unju.fi.model;

public class Candidato {
	private int codigo;
	private String nombre;
	private String genero;
	private String descripcion;
	private int cantVotos;
	private int porcentaje;
	
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

	public Candidato(int codigo, String nombre, String genero, String descripcion, int cantVotos, int porcentaje) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.genero = genero;
		this.descripcion = descripcion;
		this.cantVotos = cantVotos;
		this.porcentaje = porcentaje;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	

}
