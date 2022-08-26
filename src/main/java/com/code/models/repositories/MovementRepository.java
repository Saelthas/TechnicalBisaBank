package com.code.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.code.models.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long>{

	public Optional<List<Movement>> findAllMovementsByIdAccount(Long idAccount);
	
	public Optional<Movement> findTop1ByIdAccountOrderByIdDesc(Long idAccount);
}
