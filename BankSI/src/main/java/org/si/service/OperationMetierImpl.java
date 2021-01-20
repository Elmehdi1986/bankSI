package org.si.service;

import java.util.Date;
import java.util.Optional;

import org.si.entities.Account;
import org.si.entities.Depositing;
import org.si.entities.Employee;
import org.si.entities.Operation;
import org.si.entities.Withdrawaling;
import org.si.repository.AccountRepository;
import org.si.repository.EmployeeRepository;
import org.si.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OperationMetierImpl implements OperationMetier {
    
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	OperationRepository operationRepositor;
	
	/**
	 * @author Elmehdi
	 * @param AccountNumber, amount, codeEmployee must not be null
	 * @return  Operation
	 * 
	 * 
	 * */
	@Override
	public Operation deposit(String code, double amount, Long codeEmp) {
		Optional<Account> ac = accountRepository.findById(code);
		Optional<Employee> opEmp = employeeRepository.findById(codeEmp);
		if (amount < 1) {
			throw new RuntimeException("the  Amount is lower than 1");
		}
		if (!ac.isPresent()) {
			throw new RuntimeException("the Account doesnt exist");
		}
		if (!opEmp.isPresent()) {
			throw new RuntimeException("the Employee doesnt exist");
		}
		ac.get().setBalance(ac.get().getBalance()+amount);
		Operation operation = new Depositing(new Date(), amount);
		operation.setEmployee(opEmp.get());
		operation.setAccount(ac.get());

		return operationRepositor.save(operation);
	}

	@Override
	public Operation withraw(String code, double amount, Long codeEmp) {
		Optional<Account> ac = accountRepository.findById(code);
		Optional<Employee> opEmp = employeeRepository.findById(codeEmp);
		if (amount < 1) {
			throw new RuntimeException("the  Amount is lower than 1");
		}
		if (!ac.isPresent()) {
			throw new RuntimeException("the Account doesnt exist");
		}
		if (ac.get().getBalance()<amount) {
			throw new RuntimeException("the Amount greater than balance");
		}
		if (!opEmp.isPresent()) {
			throw new RuntimeException("the Employee doesnt exist");
		}
		ac.get().setBalance(ac.get().getBalance()-amount);
		Operation operation = new Withdrawaling(new Date(), amount);
		operation.setEmployee(opEmp.get());
		operation.setAccount(ac.get());
		
		return operationRepositor.save(operation);
	}

	@Override
	public boolean virement(String cpt1, String copt2, double amount, Long emp) {
		Optional<Account> ac1 = accountRepository.findById(cpt1);
		Optional<Account> ac2 = accountRepository.findById(copt2);
		Optional<Employee> opEmp = employeeRepository.findById(emp);
		
		Operation op1= withraw(cpt1, amount,  emp);
		Operation op2=deposit(copt2, amount, emp); 
		boolean isdone=op1 != null? true:false;
		return isdone;
	}

}
