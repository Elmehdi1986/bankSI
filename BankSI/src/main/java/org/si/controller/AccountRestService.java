package org.si.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.si.entities.Account;
import org.si.entities.CheckingAccount;
import org.si.entities.SavingAccount;
import org.si.exception.InvalidFeildException;
import org.si.service.AccountMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestService {

	@Autowired
	AccountMetier accountMetier;

	@RequestMapping(value = "/Accounts", method = RequestMethod.GET)
	public List<Account> getAllAccount() {
		return accountMetier.getAllAccount();
	}

	@RequestMapping(value = "/addAccount", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		CheckingAccount check;
		SavingAccount saveAccount;
		
		if(account.getBalance()==0) {
			throw new InvalidFeildException("the balance must be greater than "+account.getBalance());
		}
		if(account.getClass().isAssignableFrom(CheckingAccount.class) ) {
		 check=(CheckingAccount) account;
		 if(check.getOverDraft()==0) {
			 throw new InvalidFeildException("the  OverDraft must be greater than "+check.getOverDraft());
		 }
		}else if (account.getClass().isAssignableFrom(SavingAccount.class)) {
			saveAccount=(SavingAccount) account;
			 if(saveAccount.getAccountInterest()<1.5) {
				 throw new InvalidFeildException("the  Account Interest must be greater than "+saveAccount.getAccountInterest());
			 }
		}
		
		
		
		//if we want return the id only 
		/*
		 * Map<String,Object> m=new LinkedHashMap<String, Object>(); Account
		 * ac2=accountMetier.addAccount(account);
		 * m.put("codeAccount",ac2.getNumAccount()); return new
		 * ResponseEntity<Object>(m, HttpStatus.ACCEPTED);
		 */
		return new ResponseEntity<Account>(accountMetier.addAccount(account), HttpStatus.ACCEPTED);
				
	}
	
	@RequestMapping(value = "/Account/{id}", method = RequestMethod.GET)
	public Account getAccountById(@PathVariable(name = "id") String id) {
		return accountMetier.getAccountById(id);
	}
	
}
