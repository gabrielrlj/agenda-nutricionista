package com.jardim.nutri.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jardim.nutri.domain.Nutricionista;
import com.jardim.nutri.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

	/*
	 * 
	 * @Query(" select p from Paciente p where p.nutricionista = :obj ")
	 * List<Paciente> pesquisarPacientes(@Param("nome")Nutricionista obj);
	 */
	
	List<Paciente> findByNutricionista(Nutricionista nutricionista);
}
