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
	
	@Autowired
	private ConsultaService consulService;

	public Paciente find(Integer id) {
		Optional<Paciente> obj = paciRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id, Paciente.class.getName()));
	}

	public List<Paciente> findAll() {
		return paciRepo.findAll();
	}

	public Paciente save(Paciente obj) {

		Nutricionista nutri = nutriService.find(obj.getNutricionista().getId());

		//Paciente newPaciente = new Paciente(null, obj.getNome(), obj.getCpf(), obj.getIdade(), obj.getSexo(), nutri);
		obj.setNutricionista(nutri);
		paciRepo.save(obj);
		// nutri.getPacientes().add(newPaciente);
		// nutriService.save(nutri);
		return obj;
	}

	public void delete(Integer id) throws com.jardim.nutri.services.exceptions.ObjectNotFoundException{

		Paciente p1 = this.find(id);
		consulService.removerConsultasDoPaciente(p1);
		paciRepo.delete(p1);

	}

	public Paciente update(Integer id, Paciente obj) {
		Paciente p = this.find(id);
		p.setNome(obj.getNome());
		p.setCpf(obj.getCpf());
		p.setIdade(obj.getIdade());
		p.setSexo(obj.getSexo());
		// p.setNutricionista(obj.getNutricionista());
		return paciRepo.save(p);
	}
	
	public List<Paciente> listarPacientesPorNutri(Integer id){
		Nutricionista n = this.nutriService.find(id);

		return paciRepo.findByNutricionista(n);
	}
}
