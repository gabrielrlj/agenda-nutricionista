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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jardim.nutri.domain.Consulta;
import com.jardim.nutri.services.ConsultaService;

@RestController
@RequestMapping("/consultas")
@CrossOrigin("*")
public class ConsultaResource {
	
	@Autowired
	private ConsultaService service;
	
	@GetMapping
	public ResponseEntity<List<Consulta>> findAll(){
		List<Consulta> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> find(@PathVariable Integer id) {
		Consulta nutri = service.find(id);
		return ResponseEntity.ok().body(nutri);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Consulta obj) {
		obj = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Consulta obj) {
		obj.setId(id);
		obj = service.update(id, obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/nutri/{id}")
	public List<Consulta> buscarConsultasPorNutricionista(@PathVariable Integer id){
		return service.buscarConsultasPorNutricionista(id);
	}
	
	@CrossOrigin
	@GetMapping("/busca")
	public List<Consulta> buscarPorNome( 
			@RequestParam(value="nome", required = false, defaultValue = "") String nome){
		

		String nomePesquisa = "%"+nome+"%";
		return service.findByNomePaciente(nomePesquisa);
	
	}
	
	
}
