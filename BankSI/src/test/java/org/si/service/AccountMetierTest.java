package org.si.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.omg.CORBA.DATA_CONVERSION;
import org.si.entities.Account;
import org.si.entities.CheckingAccount;
import org.si.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountMetierTest {
	
	  @MockBean 
	  AccountRepository accountRepository;
	 
	@Autowired
	AccountMetier accountMetier;

	@Test
	public void  testaddAccount() {
	
		Account ac1=new CheckingAccount("AC3",new Date(), 500, -500);
		accountMetier.addAccount(ac1);
        verify(accountRepository,times(1)).save(ac1);
		
	}
	@Test
	public void testGetAllAccount() {

		
		Account ac1=new CheckingAccount("AC1",new Date(), 500, -500);
		Account ac2=new CheckingAccount("AC2",new Date(), 500, -500);
		Account ac3=new CheckingAccount("AC3",new Date(), 500, -500);
		
		List<Account> acList=new ArrayList<Account>();
		acList.add(ac1);
		acList.add(ac2);
		acList.add(ac3);
		Mockito.when(accountRepository.findAll()).thenReturn(acList);
		List<Account> ListAc=accountMetier.getAllAccount();
		assertThat(ListAc.size()).isEqualTo(3);
		verify(accountRepository,times(1)).findAll();
		

	}
	@Test
	public void testRemoveAccount() {
		Account ac1=new CheckingAccount("AC3",new Date(), 500, -500);
		accountMetier.deleteAccount(ac1.getNumAccount());
        verify(accountRepository,times(1)).deleteById(ac1.getNumAccount());
	}

}
