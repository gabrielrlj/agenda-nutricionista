package com.jardim.nutri.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jardim.nutri.domain.Paciente;
import com.jardim.nutri.repositories.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repo;
	
	public Paciente find(Integer id) {
		Optional<Paciente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(id, Paciente.class.getName()));
	}
	
	public List<Paciente> findAll(){
		return repo.findAll();
	}
	
	public Paciente save(Paciente obj) {
		//Paciente newObj = new Paciente(obj.getId(), obj.getNome(), cpf, idade, sexo)
		return repo.save(obj);
	}
}
