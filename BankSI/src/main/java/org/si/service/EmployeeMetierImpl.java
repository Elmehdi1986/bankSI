package org.si.service;

import java.util.List;

import org.si.entities.Employee;
import org.si.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMetierImpl implements EmployeeMetier {
	
    @Autowired
	EmployeeRepository employeeRepository; 
	@Override
	public Employee addEmployee(Employee employee) {
		if(employee == null) {
			throw new RuntimeException("the value of employee is null");
		}
		return employeeRepository.save(employee);
	}

	@Override
	public void removeEmployee(Long id) {
		
		 employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getEmployeesByMc(String mc) {
		// TODO Auto-generated method stub
		//return employeeRepository.findByNameContains(mc);
		return null;
	}

}
