package org.si.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long code;
	private String name;
	@OneToMany(mappedBy = "client")
	private List<Account> accounts;

	public Client() {
		super();
	}

	public Client(String name) {
		super();
		this.name = name;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
