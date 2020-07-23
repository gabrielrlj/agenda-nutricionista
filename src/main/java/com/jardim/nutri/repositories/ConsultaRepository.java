package com.jardim.nutri.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jardim.nutri.domain.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{

	@Query(" select c from Consulta c join c.paciente p where upper(p.nome) like upper( :nome ) ")
	List<Consulta> pesquisarNome(@Param("nome")String nome);

	
	//List<Consulta> findByPaciente(Paciente p);	
}
