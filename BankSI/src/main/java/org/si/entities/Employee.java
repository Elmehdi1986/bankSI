package org.si.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long codeEmployee;
	private String nomEmployee;
    @ManyToOne
    @JoinColumn(name = "EMPID")
	private Employee employee;
    @ManyToMany
    @JoinTable(name = "group_EMP")
	private List<Groupe> groupes;

	public Employee() {
		super();
	}

	public Employee(String nomEmployee) {
		super();
		this.nomEmployee = nomEmployee;
	}

	public Long getCodeEmployee() {
		return codeEmployee;
	}

	public void setCodeEmployee(Long codeEmployee) {
		this.codeEmployee = codeEmployee;
	}

	public String getNomEmployee() {
		return nomEmployee;
	}

	public void setNomEmployee(String nomEmployee) {
		this.nomEmployee = nomEmployee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

}
