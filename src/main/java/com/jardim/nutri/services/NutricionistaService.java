package com.jardim.nutri.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jardim.nutri.domain.Nutricionista;
import com.jardim.nutri.domain.Paciente;
import com.jardim.nutri.repositories.NutricionistaRepository;

@Service
public class NutricionistaService {
	
	@Autowired
	private NutricionistaRepository repo;
	
	public Nutricionista find(Integer id) {
		Optional<Nutricionista> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(id, Nutricionista.class.getName()));
	}
	
	public List<Nutricionista> findAll(){
		return repo.findAll();
	}
	
	public Nutricionista save(Nutricionista obj) {
		return repo.save(obj);
	}
	
	/*public List<Paciente> retornaPacientesPorNutricionista(Integer id) {
		return  this.find(id).getPacientes();
	}*/
	
	public void delete(Integer id) {
		Nutricionista nutri = this.find(id);
		repo.delete(nutri);
	}
	
	public Nutricionista update(Integer id, Nutricionista obj) {
		Nutricionista n1 = this.find(id);
		n1.setNome(obj.getNome());
		n1.setCrn(obj.getCrn());
		return repo.save(n1);
	}
}
