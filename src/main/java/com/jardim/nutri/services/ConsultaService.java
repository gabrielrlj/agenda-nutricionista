package com.jardim.nutri.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jardim.nutri.domain.Consulta;
import com.jardim.nutri.domain.Paciente;
import com.jardim.nutri.repositories.ConsultaRepository;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository repo;
	
	public Consulta find(Integer id) {
		Optional<Consulta> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(id, Consulta.class.getName()));
	}
	
	public List<Consulta> findAll(){
		return repo.findAll();
	}
	
	public Consulta save(Consulta obj) {
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		Consulta nutri = this.find(id);
		repo.delete(nutri);
	}
	
	public Consulta update(Integer id, Consulta obj) {
		Consulta c = this.find(id);
		c.setInstante(obj.getInstante());
		return repo.save(c);
	}

	public List<Consulta> findByNomePaciente(String nome) {
		
		return repo.pesquisarNome(nome);
	}
	
	/*public List<Consulta> buscarPorPaciente(Paciente obj){
		return repo.findByPaciente(obj);
	}*/
}
