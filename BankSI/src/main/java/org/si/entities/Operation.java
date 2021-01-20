package org.si.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type",discriminatorType = DiscriminatorType.STRING,length = 2)
public abstract class Operation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numOperation;
	private Date dateOperation;
	private double amount;
	@ManyToOne
	@JoinColumn(name = "IDAccount")
	private Account account;
	@ManyToOne
	@JoinColumn(name = "IDEmployee")
	private Employee employee;
	
	public Operation() {
		super();
	}
	public Operation(Date dateOperation, double amount) {
		super();
		this.dateOperation = dateOperation;
		this.amount = amount;
	}
	public Long getNumOperation() {
		return numOperation;
	}
	public void setNumOperation(Long numOperation) {
		this.numOperation = numOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

}
