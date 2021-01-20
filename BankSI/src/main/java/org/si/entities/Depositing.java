package org.si.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "DP")
public class Depositing extends Operation implements Serializable {
	public Depositing() {
		// TODO Auto-generated constructor stub
	}

	public Depositing(Date dateOperation, double amount) {
		super(dateOperation, amount);
		// TODO Auto-generated constructor stub
	}

}
