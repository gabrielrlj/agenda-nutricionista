package com.jardim.nutri.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jardim.nutri.domain.Consulta;
import com.jardim.nutri.domain.Paciente;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{

	
	List<Consulta> findByPaciente(Paciente p);
}
