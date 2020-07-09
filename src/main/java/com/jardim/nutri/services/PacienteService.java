package com.jardim.nutri.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jardim.nutri.domain.Nutricionista;
import com.jardim.nutri.domain.Paciente;
import com.jardim.nutri.repositories.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository paciRepo;
	
	@Autowired
	private NutricionistaService nutriService;
	
	public Paciente find(Integer id) {
		Optional<Paciente> obj = paciRepo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(id, Paciente.class.getName()));
	}
	
	public List<Paciente> findAll(){
		return paciRepo.findAll();
	}
	
	public Paciente save(Paciente obj) {
		
		Nutricionista nutri = nutriService.find(obj.getNutricionista().getId());
		
		Paciente newPaciente = new Paciente(null, obj.getNome(), obj.getCpf(),
				obj.getIdade(), obj.getSexo(), nutri);

		paciRepo.save(newPaciente);
		nutri.getPacientes().add(newPaciente);
		nutriService.save(nutri);
		return newPaciente;
	}
}
