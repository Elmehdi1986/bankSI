package org.si.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type",discriminatorType = DiscriminatorType.STRING,length = 2)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({
	@Type(name = "CA", value = CheckingAccount.class),
	@Type(name = "SV",value = SavingAccount.class)
})
public abstract class Account implements Serializable {
	@Id
	private String numAccount;
	private Date dateCreation;
	private double balance;
    @ManyToOne
    @JoinColumn(name = "codeClient")
	private Client client;
    @OneToMany
	private List<Operation> operations;
    @ManyToOne
    @JoinColumn(name = "codeEmployee")
	private Employee employee;

	public Account() {
		super();
	}

	public Account(String numAccount, Date dateCreation, double balance) {
		super();
		this.numAccount = numAccount;
		this.dateCreation = dateCreation;
		this.balance = balance;
	}

	public String getNumAccount() {
		return numAccount;
	}

	public void setNumAccount(String numAccount) {
		this.numAccount = numAccount;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
