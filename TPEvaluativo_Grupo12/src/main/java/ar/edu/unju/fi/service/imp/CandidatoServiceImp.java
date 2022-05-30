package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Candidato;
import ar.edu.unju.fi.service.ICandidatoService;
import ar.edu.unju.fi.util.ListaCandidato;

@Service("AlumnoServiceImpLista")
public class CandidatoServiceImp implements ICandidatoService {
	
	@Autowired
	private ListaCandidato listaCandidato;

	@Override
	public Candidato getCandidato() {
		// retorna un obj candidato
		return new Candidato();
	}

	@Override
	public boolean guardarCandidato(Candidato candidato) {
		// guarda un candidato en la lista de candidatos
		return listaCandidato.getCandidatos().add(candidato);
	}

	@Override
	public void modificarCandidato(Candidato candidato) {
		// buscar el candidato por codigo y actualizarlo
		for(Candidato candid : listaCandidato.getCandidatos()) {
			if(candid.getCodigo() == candidato.getCodigo()) {
				candid.setNombre(candidato.getNombre());
				candid.setGenero(candidato.getGenero());
				candid.setDescripcion(candidato.getDescripcion());
				candid.setCantVotos(candidato.getCantVotos());
			}
		}
	}

	@Override
	public void eliminarCandidato(int codigo) {
		// TODO Auto-generated method stub
		for (int i = listaCandidato.getCandidatos().size(); i > 0; i--) {
			//if (can.getCodigo() == codigo) {
			if (listaCandidato.getCandidatos().get(i-1).getCodigo() == codigo) {
				listaCandidato.getCandidatos().remove(i-1);
			}
		}
	}

	@Override
	public ListaCandidato getListaCandidato() {
		// retorna el objeto instanciado como lista de candidatos
		return listaCandidato;
	}

	@Override
	public Candidato buscarCandidato(int codigo) {
		// busca un candidato, y devuelve el objeto encontrado
		Optional<Candidato> candidato = listaCandidato.getCandidatos().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		return candidato.get();
	}

	@Override
	public ListaCandidato obtenerPorcentajes() {
		// TODO Auto-generated method stub
		int totalvotos=0;
		double porcentaje=0;
		for(Candidato candid : listaCandidato.getCandidatos()) {
			totalvotos=totalvotos+candid.getCantVotos();
		}
		for(int i=0;i<listaCandidato.getCandidatos().size();i++) {
			int votoindividual = listaCandidato.getCandidatos().get(i).getCantVotos();
			porcentaje=((100.0*votoindividual)/totalvotos);
			System.out.println(i+"--"+porcentaje);
			listaCandidato.getCandidatos().get(i).setPorcentaje(porcentaje);
			
		}
		return listaCandidato;
	}

	@Override
	public ListaCandidato mostrarVotacion() {
		// TODO Auto-generated method stub
		int totalvotos=0;
		double porcentaje=0;
		for(Candidato candid : listaCandidato.getCandidatos()) {
			totalvotos=totalvotos+candid.getCantVotos();
			System.out.println(totalvotos);
		}
		for(int i=0;i<listaCandidato.getCandidatos().size();i++) {
			int votoindividual = listaCandidato.getCandidatos().get(i).getCantVotos();
			porcentaje=((100.0*votoindividual)/totalvotos);
			System.out.println(i+"--"+porcentaje);
			listaCandidato.getCandidatos().get(i).setPorcentaje(porcentaje);
			
		}
		return listaCandidato;
	}

	@Override
	public Candidato votar(int codigo) {
		// TODO Auto-generated method stub
		for(int i=0;i<listaCandidato.getCandidatos().size();i++) {
			if(listaCandidato.getCandidatos().get(i).getCodigo() == codigo) {
				int cantvotos = listaCandidato.getCandidatos().get(i).getCantVotos();
				listaCandidato.getCandidatos().get(i).setCantVotos(cantvotos+1);
			}
		}
		return null;
	}

}
