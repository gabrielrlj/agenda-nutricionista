package com.jardim.nutri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jardim.nutri.domain.Nutricionista;
import com.jardim.nutri.domain.Paciente;
import com.jardim.nutri.domain.enums.Sexo;
import com.jardim.nutri.services.NutricionistaService;
import com.jardim.nutri.services.PacienteService;

@SpringBootApplication
public class AgendaConsultaApplication implements CommandLineRunner{

	@Autowired
	private NutricionistaService nutriService;
	@Autowired
	private PacienteService paciService;
	
	public static void main(String[] args) {
		SpringApplication.run(AgendaConsultaApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		Nutricionista n1 = new Nutricionista(null, "paulo kogos", "1234");
		nutriService.save(n1);
		Paciente p1 = new Paciente(null, "Juvenal", "12345612345", 52, Sexo.MASCULINO, n1);
		paciService.save(p1);
		n1.getPacientes().add(p1);
	}

}
