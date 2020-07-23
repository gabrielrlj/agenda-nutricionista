package com.jardim.nutri.configs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jardim.nutri.domain.Consulta;
import com.jardim.nutri.domain.Nutricionista;
import com.jardim.nutri.domain.Paciente;
import com.jardim.nutri.domain.enums.Sexo;
import com.jardim.nutri.services.ConsultaService;
import com.jardim.nutri.services.NutricionistaService;
import com.jardim.nutri.services.PacienteService;

@Configuration
@Profile("test")
public class ConfiguracaoTeste implements CommandLineRunner{
	
	@Autowired
	private NutricionistaService nutriService;
	@Autowired
	private PacienteService paciService;
	@Autowired
	private ConsultaService consulService;
	
	
	@Override
	public void run(String... args) throws Exception {
		Nutricionista n1 = new Nutricionista(null, "paulo kogos", "1234");
		nutriService.save(n1);
		Paciente p1 = new Paciente(null, "Juvenal", "41167849078", 52, Sexo.MASCULINO, n1);
		paciService.save(p1);
		Date d = new Date("2020/03/30 14:00");
		Consulta c1 = new Consulta();
		c1.setId(null);
		c1.setInstante(d);
		c1.setPaciente(p1);
		consulService.save(c1);
		
	}
	
	
}
