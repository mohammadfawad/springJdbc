package com.springframework.springJdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/springframework/springJdbc/configDriverManagerDataSource.xml");
		JdbcTemplate jbcTemplate = (JdbcTemplate) context.getBean("jbcTemplate");
		String sql = "INSERT INTO employee VALUES(?,?,?)";
		int numberOfRecordsInserted = jbcTemplate.update(sql, 41199, "Mir Mustehsan Jameel", "Major");
		System.out.println("::( Classes used DrivermnagerDataSource and JdbcTemplate)::\n Spring JDBC # of records Inserted ::" + numberOfRecordsInserted);
	}

}
;