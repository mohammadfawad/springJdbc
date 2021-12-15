package com.springframework.springJdbc.Employee.DAO;

import java.util.List;

import com.springframework.springJdbc.Employee.Entity.Employee;

public interface EmployeeDAO {
	
	int createEmployee(Employee employee);
	int updateEmployee(Employee employee);
	int deleteEmployee(int employeeId);
	Employee getEmployee(int employeeId);
	List<Employee> gatAllEmployees();
}
