package org.si.service;

import java.util.List;

import org.si.entities.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountMetier {

	public Account addAccount(Account account);
	public void deleteAccount(String numAccount);
	public List<Account> getAllAccount();
	public Account getAccountById(String id);
	
}
