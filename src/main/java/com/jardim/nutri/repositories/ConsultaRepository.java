package com.jardim.nutri.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.jardim.nutri.domain.Nutricionista;
import com.jardim.nutri.domain.Consulta;
import com.jardim.nutri.domain.Paciente;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{

	@Query(" select c from Consulta c join c.paciente p where upper(p.nome) like upper( :nome ) ")
	List<Consulta> pesquisarNome(@Param("nome")String nome);
	
	List<Consulta> findAllByPaciente(Paciente p);
	
	@Query(" select c from Consulta c join c.paciente p where p.nutricionista = :n ")
	List<Consulta>findAllByNutricionista(@Param("n")Nutricionista n);
}
