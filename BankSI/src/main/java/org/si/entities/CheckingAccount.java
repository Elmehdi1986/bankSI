package org.si.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value = "CA")
public class CheckingAccount extends Account implements Serializable {
	
	private double overDraft;

	public CheckingAccount() {
		super();
	}

	
	public CheckingAccount(String numAccount, Date dateCreation, double balance,double overDraft) {
		super(numAccount, dateCreation, balance);
		this.overDraft=overDraft;
	}


	public CheckingAccount(double overDraft) {
		super();
		this.overDraft = overDraft;
	}

	public double getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	}

}
