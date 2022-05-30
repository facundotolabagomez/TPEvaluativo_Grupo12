package ar.edu.unju.fi.service;

import ar.edu.unju.fi.model.Candidato;
import ar.edu.unju.fi.util.ListaCandidato;

public interface ICandidatoService {
	public Candidato getCandidato();
	public boolean guardarCandidato(Candidato candidato);
	public void modificarCandidato(Candidato candidato);
	public void eliminarCandidato(int codigo);
	public ListaCandidato getListaCandidato();
	public Candidato buscarCandidato(int codigo);
	public ListaCandidato obtenerPorcentajes();
	public ListaCandidato mostrarVotacion();
	public Candidato votar(int codigo);
	
}
