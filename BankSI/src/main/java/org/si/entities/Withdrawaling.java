package org.si.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value = "WD")
public class Withdrawaling extends Operation implements Serializable {

	public Withdrawaling() {
		// TODO Auto-generated constructor stub
	}

	public Withdrawaling(Date dateOperation, double amount) {
		super(dateOperation, amount);
		// TODO Auto-generated constructor stub
	}

}
