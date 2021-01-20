package org.si;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.si.entities.Account;
import org.si.entities.CheckingAccount;
import org.si.entities.Client;
import org.si.entities.Employee;
import org.si.entities.Groupe;
import org.si.repository.AccountRepository;
import org.si.repository.ClientRepository;
import org.si.repository.EmployeeRepository;
import org.si.repository.GroupeRepository;
import org.si.service.AccountMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankSiApplication implements CommandLineRunner {
    @Autowired 
	AccountRepository AccountRepository;
    @Autowired
	EmployeeRepository employeeRepository ;
    @Autowired
	ClientRepository clientRepository;
    @Autowired
	GroupeRepository groupeRepository; 
    
    
	
	public static void main(String[] args) {
		SpringApplication.run(BankSiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		  List<Employee> l, l2, l3; Client c1,c2,c3,c4,c5,c6; 
		  Employee emp1,emp2,emp3,emp4,emp5,emp6,emp7; l = new ArrayList<Employee>();
		  l2 = new ArrayList<Employee>(); l3 = new ArrayList<Employee>(); c1 = new
		  Client("Mehdi"); 
		  c2 = new Client("Morad"); c3 = new Client("Hicham");
		  
		  c4 = clientRepository.save(c1);
		  c5 = clientRepository.save(c2);
		  c6 = clientRepository.save(c3);
		  
		  emp1 = new Employee("SIMO");
		  emp2 = new Employee("ANAS");
		  emp3 = new
		  Employee("ZOBIR");
		  
		  emp4 = employeeRepository.save(emp1);
		  emp5 = employeeRepository.save(emp2);
		  emp6 = employeeRepository.save(emp3);
		  
		  l.add(emp4); l2.add(emp5); l3.add(emp6);
		  
		  Groupe g1 = new Groupe("G1");
		  g1.setEmployees(l); 
		  Groupe g2 = new
		  Groupe("G2");
		  g2.setEmployees(l2);
		  Groupe g3 = new Groupe("G3");
		  g3.setEmployees(l3);
		  
		  groupeRepository.save(g1);
		  groupeRepository.save(g2);
		  groupeRepository.save(g3);
		  emp7 =  employeeRepository.findById(emp1.getCodeEmployee()).get(); List<Groupe> g=new
		  ArrayList<Groupe>(); 
		  g.add(g1);
		  emp7.setGroupes(g);
		  employeeRepository.save(emp7);
		  
		  Account ac1=new CheckingAccount("AC1", new Date(), 500, -500);
		  Account ac2=new CheckingAccount("AC2", new Date(), 500, -500);
		  Account ac3=new CheckingAccount("AC3", new Date(), 500, -500);
		  
		  AccountRepository.save(ac1);
		  AccountRepository.save(ac2);
		  AccountRepository.save(ac3);
		  
		  
		 	
		
	}
	

	

}
