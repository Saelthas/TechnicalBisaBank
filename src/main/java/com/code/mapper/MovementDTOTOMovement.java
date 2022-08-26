package com.code.mapper;


import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.code.models.Movement;

import com.code.models.MovementDTO.MovementDTO;

@Component
public class MovementDTOTOMovement implements IMapper<MovementDTO, Movement> {

	@Override
	public Movement map(MovementDTO in) {
		// TODO Auto-generated method stub
		Movement movement = new Movement();
		movement.setAmount(in.getAmount());
		movement.setIdAccount(in.getIdAccount());
		movement.setTypeMovement(in.getTypeMovement());
		movement.setDateMovement(LocalDateTime.now());
		movement.setCurrency(in.getCurrency());
		
		return movement;
	}

}
