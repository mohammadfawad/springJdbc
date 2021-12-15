package com.springframework.springJdbc.Employee.DAO.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.springframework.springJdbc.Employee.DAO.EmployeeDAO;
import com.springframework.springJdbc.Employee.DAO.RowMapper.EmployeeRowMapper;
import com.springframework.springJdbc.Employee.Entity.Employee;

@Component("employeeDAOImplementation")
public class EmployeeDAOImplementation implements EmployeeDAO {
	@Autowired
	@Qualifier("jbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public int createEmployee(Employee employee) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO employee VALUES (?,?,?)";
		return this.getJdbcTemplate().update(sql, employee.getId(), employee.getFirstName(), employee.getLastName());
	}

	@Override
	public int updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String sql = "UPDATE `employee` SET `firstName` = ?,`lastName` = ? WHERE `employee`.`employeeId` = ?";
		return this.getJdbcTemplate().update(sql, employee.getFirstName(), employee.getLastName(), employee.getId());
	}

	@Override
	public int deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM `employee` WHERE `employee`.`employeeId` = ?";

		return this.getJdbcTemplate().update(sql, employeeId);
	}

	@Override
	public Employee getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `employee` WHERE `employee`.`employeeId` = ?";
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		return (Employee) this.getJdbcTemplate().queryForObject(sql, employeeRowMapper, employeeId);

	}

	@Override
	public List<Employee> gatAllEmployees() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `employee`";
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		return (List<Employee>)this.getJdbcTemplate().query(sql, employeeRowMapper);
	}

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
}
