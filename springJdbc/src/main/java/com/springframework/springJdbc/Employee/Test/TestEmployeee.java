package com.springframework.springJdbc.Employee.Test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springframework.springJdbc.Employee.DAO.EmployeeDAO;
import com.springframework.springJdbc.Employee.Entity.Employee;

public class TestEmployeee {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/springframework/springJdbc/Employee/Test/configDriverManagerDataSource.xml");
		EmployeeDAO employeeDAO =  (EmployeeDAO) context.getBean("employeeDAOImplementation");
		//INSERT Employee
		Employee employee = new Employee();
		employee.setId(1292);
		employee.setFirstName("Mohammad Fawad");
		employee.setLastName("Bhatti");
		System.out.println("Spring JDBCTemplate :: \n Record INSERTED = " + employeeDAO.createEmployee(employee));
		//UPDATE Employee
		Employee employeeUpdate =  new Employee();
		employeeUpdate.setId(1291);
		employeeUpdate.setFirstName("Bhatti");
		employeeUpdate.setLastName("Mohammad Fawad");
		System.out.println("Spring JDBCTemplate :: \n Record UPDATED = " + employeeDAO.updateEmployee(employeeUpdate));
		//DELETE Employee
		System.out.println("Spring JDBCTemplate :: \n Record DELETED = " + employeeDAO.deleteEmployee(1289));
		//SELECT Employee Single
		System.out.println("Spring JDBCTemplate :: \n Record SINGLE = " + employeeDAO.getEmployee(1291));
		//SELECT Employee Multiple
		System.out.println("Spring JDBCTemplate :: \n Record MULTIPLE = " + employeeDAO.gatAllEmployees());
	}

}
