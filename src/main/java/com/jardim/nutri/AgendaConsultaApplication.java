package com.jardim.nutri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jardim.nutri.domain.Nutricionista;
import com.jardim.nutri.services.NutricionistaService;

@SpringBootApplication
public class AgendaConsultaApplication implements Runnable{

	@Autowired
	private NutricionistaService service;
	
	public static void main(String[] args) {
		SpringApplication.run(AgendaConsultaApplication.class, args);
	}

	@Override
	public void run() {
		
		Nutricionista n1 = new Nutricionista(null, "paulo kogos", "1234");
		service.save(n1);
		
	}

}
