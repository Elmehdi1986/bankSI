package org.si.service;

import java.util.List;

import org.si.entities.Employee;

public interface EmployeeMetier {
	public Employee addEmployee(Employee employee);

	public void removeEmployee(Long id);

	public List<Employee> getAllEmployees();

	public List<Employee> getEmployeesByMc(String mc);
}
