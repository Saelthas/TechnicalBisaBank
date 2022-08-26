package com.code.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.code.exceptions.TestExceptions;
import com.code.mapper.MovementDTOTOMovement;
import com.code.models.Account;
import com.code.models.Movement;
import com.code.models.StatusAccount;
import com.code.models.MovementDTO.MovementDTO;
import com.code.models.repositories.AccountRepository;
import com.code.models.repositories.MovementRepository;
import com.code.util.Validators;

@Service
public class MovementService {
	private final AccountRepository repositoryAccounts ;
	private final MovementRepository repositoryMovements ;
	private final MovementDTOTOMovement mapper;
	
	public MovementService(MovementRepository repository, MovementDTOTOMovement mapper,AccountRepository _repositoryAccounts) {
		
		this.repositoryAccounts = _repositoryAccounts;
		this.repositoryMovements = repository;
		this.mapper = mapper;
	}
	@Transactional
	public Movement CreateMovement(MovementDTO movementDTO)
	{
		Movement movement = mapper.map(movementDTO);
		Optional<Movement> responseBD = repositoryMovements.findTop1ByIdAccountOrderByIdDesc(movement.getIdAccount());
		Optional<Account> respAccoBD = repositoryAccounts.findById(movement.getIdAccount());
		
		Validators.ValidateDTO(respAccoBD.get(),movementDTO);
		
		if(respAccoBD.isEmpty())
			throw new TestExceptions("Account ID no encontrado", HttpStatus.NOT_FOUND);
		
		switch (movement.getTypeMovement()) {
		case "D":
			movement.setCurrentBalance(responseBD.get().getCurrentBalance()-movement.getAmount());
			movement.setPreviusBalance(responseBD.get().getCurrentBalance());
			if (respAccoBD.get().getStatus()==StatusAccount.Active) {
				repositoryMovements.save(movement);
				if(responseBD.get().getCurrentBalance()<=movement.getAmount())
					repositoryAccounts.statusAccountHold(movement.getIdAccount());
			}
			else 
				throw new TestExceptions("No se pueden Realizar Debitos a esta cuenta, Estado: HOLD", HttpStatus.NOT_ACCEPTABLE);
			break;
		case "C":
			movement.setCurrentBalance(responseBD.get().getCurrentBalance()+movement.getAmount());
			movement.setPreviusBalance(responseBD.get().getCurrentBalance());
			repositoryMovements.save(movement);
			if (respAccoBD.get().getStatus()==StatusAccount.Hold) {

				if(responseBD.get().getCurrentBalance()<=movement.getAmount())
					repositoryAccounts.statusAccountActive(movement.getIdAccount());
			}
			break;
		default:
			break;
		}
		return repositoryMovements.save(movement);
	}
	
	public Optional<List<Movement>> findMovementsById(Long idAccount)
	{
		//Movement  movement = this.mapper.map(movementDTO);
		return (repositoryMovements.findAllMovementsByIdAccount(idAccount));
	}
	
}
