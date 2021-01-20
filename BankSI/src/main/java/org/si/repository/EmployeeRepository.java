package org.si.repository;

import java.util.List;

import org.si.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	//List<Employee> findByNameContains(String mc);
}
