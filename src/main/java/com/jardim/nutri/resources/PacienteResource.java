package com.jardim.nutri.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jardim.nutri.domain.Paciente;
import com.jardim.nutri.services.PacienteService;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin("*")
public class PacienteResource {
	
	@Autowired
	private PacienteService service;
	
	@GetMapping
	public ResponseEntity<List<Paciente>> findAll(){
		List<Paciente> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/nutri/{id}")
	public List<Paciente> findAllByNutricionista(@PathVariable Integer id){
		List<Paciente> list = service.listarPacientesPorNutri(id);
		return list;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> find(@PathVariable Integer id) {
		Paciente paci = service.find(id);
		return ResponseEntity.ok().body(paci);
	}
	
	@PostMapping
	public ResponseEntity<Paciente> save(@Valid @RequestBody Paciente obj) {
		obj = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		ResponseEntity.created(uri).build();
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody Paciente obj) {
		obj.setId(id);
		obj = service.update(id, obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
