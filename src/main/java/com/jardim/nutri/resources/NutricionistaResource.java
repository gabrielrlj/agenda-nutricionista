package com.jardim.nutri.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jardim.nutri.domain.Nutricionista;
import com.jardim.nutri.services.NutricionistaService;
import com.jardim.nutri.services.exceptions.UsuarioCadastradoException;

@RestController
@RequestMapping("/nutricionistas")
@CrossOrigin("*")
public class NutricionistaResource {
	
	@Autowired
	private NutricionistaService service;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Nutricionista>> findAll(){
		List<Nutricionista> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	//mas faz sentido isso aqui?
	/*@GetMapping("/{id}")
	public List<Paciente> retornaPacientesPorNutricionista(@PathVariable Integer id) {
		Nutricionista nutri = service.find(id);
		
		return nutri.getPacientes();
	}*/
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Nutricionista> find(@PathVariable Integer id) {
		Nutricionista nutri = service.find(id);
		return ResponseEntity.ok().body(nutri);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Nutricionista obj) {
		try {
			
			obj = service.save(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}catch (UsuarioCadastradoException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody Nutricionista obj) {
		obj.setId(id);
		obj = service.update(id, obj);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
