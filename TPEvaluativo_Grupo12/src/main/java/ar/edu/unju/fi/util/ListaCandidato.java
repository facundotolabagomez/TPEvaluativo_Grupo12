package ar.edu.unju.fi.util;

import java.util.ArrayList;

import ar.edu.unju.fi.model.Candidato;


public class ListaCandidato {
private ArrayList<Candidato> candidatos;
	
	public ListaCandidato() {
		candidatos = new ArrayList<Candidato>();
		candidatos.add(new Candidato(1,"Queen","Rock","Banda Emblematica de Rock",2,0));
		candidatos.add(new Candidato(2,"ACDC","Rock","Banda Popular de Rock",3,0));
		candidatos.add(new Candidato(3,"Guns n Roses","Rock","Banda Problematica de Rock",1,0));
		candidatos.add(new Candidato(4,"La Mona","Cuarteto","Icono del cuarteto",1,0));
		candidatos.add(new Candidato(5,"Ninguno","-","No me gusta ninguno",3,0));
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
}
