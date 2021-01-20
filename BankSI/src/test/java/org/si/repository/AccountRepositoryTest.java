package org.si.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.si.entities.Account;
import org.si.entities.CheckingAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AccountRepositoryTest {
    @Autowired
	TestEntityManager entityManager;
    @Autowired
    AccountRepository accountRepository;
    
	@Test
	public void testSaveAccount() {
		Account account = createAccount();
		
		Account AccountSavedInDB=entityManager.persist(account);
		Account AccountFromDb=accountRepository.findById(AccountSavedInDB.getNumAccount()).get();
		assertThat(AccountSavedInDB).isEqualTo(AccountFromDb);	
	}
	@Test
	public void testGetAccountById() {
		Account account = createAccount();
		Account AccountSavedInDB=entityManager.persist(account);
		Account AccountFromDb=accountRepository.findById(AccountSavedInDB.getNumAccount()).get();
		assertThat(AccountSavedInDB).isEqualTo(AccountFromDb);
	}
	@Test
	public void testgetAllccounts() {
		Account ac1= new CheckingAccount("AC1", new Date(),500, -500);
		Account ac2= new CheckingAccount("AC2", new Date(),500, -500);
		
		Account account1SavedDB=entityManager.persist(ac1);
		Account account2SavedDB=entityManager.persist(ac2);
		
		List<Account> accountList=accountRepository.findAll();
		
		assertThat(accountList.size()).isEqualTo(2);
		
	}
	
	private Account createAccount() {
		Account ac= new CheckingAccount("AC1", new Date(),500, -500);
		return ac;
	}
	

}
