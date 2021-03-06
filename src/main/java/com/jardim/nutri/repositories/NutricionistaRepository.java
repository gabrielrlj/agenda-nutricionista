package com.jardim.nutri.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jardim.nutri.domain.Nutricionista;

@Repository
public interface NutricionistaRepository extends JpaRepository<Nutricionista, Integer>{
	
	Optional<Nutricionista> findByEmail(String email);

	boolean existsByEmail(String email);
}
