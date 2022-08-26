package com.code.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.models.Movement;
import com.code.models.MovementDTO.MovementDTO;
import com.code.service.MovementService;


@RestController
@RequestMapping("/movements")
public class MovementsController {
	private final MovementService movementService;

	public MovementsController(MovementService movementService) {
		
		this.movementService = movementService;
	}
	@PostMapping
	public Movement createMovement(@RequestBody MovementDTO movementDTO)
	{
		return movementService.CreateMovement(movementDTO);
	}
	@GetMapping("/movements/{idAccount}")
	public Optional<List<Movement>> MovementfindMovementById(@PathVariable("idAccount") Long idAccount)
	{
		return movementService.findMovementsById(idAccount);
		//return null;
	}
	
}
