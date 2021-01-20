package org.si.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "SV")
public class SavingAccount extends Account implements Serializable {
    
	private double accountInterest;

	public SavingAccount() {
		super();
	}
    
	public SavingAccount(String numAccount, Date dateCreation, double balance,double accountInterest) {
		super(numAccount, dateCreation, balance);
	  this.accountInterest=accountInterest;
	}

	public SavingAccount(double accountInterest) {
		super();
		this.accountInterest = accountInterest;
	}

	public double getAccountInterest() {
		return accountInterest;
	}

	public void setAccountInterest(double accountInterest) {
		this.accountInterest = accountInterest;
	}

}
