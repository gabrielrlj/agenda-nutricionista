package com.jardim.nutri.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jardim.nutri.domain.Paciente;
import com.jardim.nutri.services.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteResource {
	
	@Autowired
	private PacienteService service;
	
	@GetMapping
	public List<Paciente> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	public Paciente save(@RequestBody Paciente obj) {
		return service.save(obj);
	}
}
