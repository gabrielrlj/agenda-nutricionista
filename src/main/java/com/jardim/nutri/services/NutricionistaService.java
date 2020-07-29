package com.jardim.nutri.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jardim.nutri.domain.Nutricionista;
import com.jardim.nutri.domain.Paciente;
import com.jardim.nutri.repositories.NutricionistaRepository;
import com.jardim.nutri.services.exceptions.UsuarioCadastradoException;

@Service
public class NutricionistaService implements UserDetailsService{
	
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
		boolean exists = repo.existsByEmail(obj.getEmail());
		if(exists) {
			throw new UsuarioCadastradoException();
		}
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

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Nutricionista nutri = repo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Email não encontrado!"));
		return User
				.builder()
				.username(nutri.getEmail())
				.password(nutri.getPassword())
				.roles("USER")
				.build();
	}
	
	public Nutricionista findByEmail(String email) {
		Nutricionista n = repo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Email não encontrado!"));
		return n;
	}
}
