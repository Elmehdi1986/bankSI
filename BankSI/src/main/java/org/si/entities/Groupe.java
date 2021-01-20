package org.si.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Groupe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numGroupe;
	private String nomGroupe;
	@ManyToMany(mappedBy = "groupes")
	private List<Employee> employees;

	
	public Groupe() {
		super();
	}

	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}

	public Long getNumGroupe() {
		return numGroupe;
	}

	public void setNumGroupe(Long numGroupe) {
		this.numGroupe = numGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
