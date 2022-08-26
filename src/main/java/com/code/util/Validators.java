package com.code.util;

import org.springframework.http.HttpStatus;

import com.code.exceptions.TestExceptions;
import com.code.models.Account;
import com.code.models.MovementDTO.MovementDTO;

public class Validators {
	public static void ValidateDTO(Account account, MovementDTO movementDTO) {
		// TODO Auto-generated method stub
		if(!account.getCurrency().equals( movementDTO.getCurrency()))
			throw new TestExceptions("La momenda de la cuenta("+account.getCurrency()+") y la transaccion no coinciden("+movementDTO.getCurrency()+")", HttpStatus.BAD_REQUEST);
		if(movementDTO.getAmount()<=0)
			throw new TestExceptions("No se permiten transacciones negativas o con monto 0", HttpStatus.BAD_REQUEST);
	}
}
