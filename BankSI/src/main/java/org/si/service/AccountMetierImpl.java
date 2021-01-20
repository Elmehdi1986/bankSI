package org.si.service;

import java.util.Date;
import java.util.List;

import org.si.entities.Account;
import org.si.entities.CheckingAccount;
import org.si.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountMetierImpl implements AccountMetier {
    @Autowired
    private AccountRepository accountRepository;
    
    
	@Override
	public Account addAccount(Account account) {
		
		return accountRepository.save(account);
	}

	@Override
	public void deleteAccount(String numAccount) {
		// TODO Auto-generated method stub
		 accountRepository.deleteById(numAccount);
	}

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountById(String id) {
		return accountRepository.findById(id).get() ;
	}

}
