package ar.edu.unju.fi.util;

import java.util.ArrayList;

import ar.edu.unju.fi.model.Candidato;


public class ListaCandidato {
private ArrayList<Candidato> candidatos;
	
	public ListaCandidato() {
		candidatos = new ArrayList<Candidato>();
		candidatos.add(new Candidato(1,"Queen","Rock","Banda Emblematica de Rock",0));		
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
}
