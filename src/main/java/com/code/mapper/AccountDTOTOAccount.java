package com.code.mapper;

import org.springframework.stereotype.Component;

import com.code.models.Account;
import com.code.models.StatusAccount;
import com.code.models.AccountDTO.AccountDTO;
@Component
public class AccountDTOTOAccount implements IMapper<AccountDTO, Account>{

	@Override
	public Account map(AccountDTO in) {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setAccount(in.getAccount());
		account.setClientName(in.getClientName());
		account.setCurrency(in.getCurrency());
		account.setIdClient(in.getIdClient());
		account.setStatus(StatusAccount.Active);
		return account;
	}
	
	
	
}
