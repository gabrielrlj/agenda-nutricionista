package com.jardim.nutri.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jardim.nutri.domain.Nutricionista;
import com.jardim.nutri.services.NutricionistaService;

@RestController
@RequestMapping("/nutricionistas")
public class NutricionistaResource {
	
	@Autowired
	private NutricionistaService service;
	
	@GetMapping
	public List<Nutricionista> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	public Nutricionista save(@RequestBody Nutricionista obj) {
		return service.save(obj);
	}
}
