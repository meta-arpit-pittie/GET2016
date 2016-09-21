/**
 * Assignment 1
 * Data Access Object class
 * To interact with the database
 * @author Arpit Pittie
 */
package com.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	
	private static EmployeeDAO employeeDAO = null;	//EmployeeDAO for implementing singleton pattern
	
	private EmployeeDAO() {
		
	}
	
	/**
	 * To get the employee details by its id
	 * @param id - ID of the employee
	 * @return The List of employee
	 */
	public List<Employee> getEmployeeById(int id) {
		List<Employee> listEmployee = new ArrayList<Employee>();
		//Getting the connection object
		Connection connection = ConnectionFactory.getConnection();
		try {
			//Creating the prepared statement query
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE idemployee = ?");
			//Setting the parameters to the prepared statement
			statement.setInt(1, id);
			//Executing the query
			ResultSet result = statement.executeQuery();
			
			//Iterating over the result set
			while(result.next()) {
				Employee employee = new Employee();
				employee.setId(result.getInt("idemployee"));
				employee.setName(result.getString("name"));
				employee.setCity(result.getString("city"));
				employee.setAge(result.getInt("age"));
				employee.setSalary(result.getInt("salary"));
				
				listEmployee.add(employee);
			}
			
			result.close();
			statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEmployee;
	}
	
	/**
	 * To get the employee details by its name
	 * @param name - name of the employee
	 * @return The List of employee
	 */
	public List<Employee> getEmployeeByName(String name) {
		List<Employee> listEmployee = new ArrayList<Employee>();
		//Getting the connection object
		Connection connection = ConnectionFactory.getConnection();
		try {
			//Creating the prepared statement query
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE name = ?");
			//Setting the parameters to the prepared statement
			statement.setString(1, name);
			//Executing the query
			ResultSet result = statement.executeQuery();
			
			//Iterating over the result set
			while(result.next()) {
				Employee employee = new Employee();
				employee.setId(result.getInt("idemployee"));
				employee.setName(result.getString("name"));
				employee.setCity(result.getString("city"));
				employee.setAge(result.getInt("age"));
				employee.setSalary(result.getInt("salary"));
				
				listEmployee.add(employee);
			}
			
			result.close();
			statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEmployee;
	}
	
	/**
	 * To get all the employees
	 * @return - List of all employees
	 */
	public List<Employee> getEmployees() {
		List<Employee> listEmployee = new ArrayList<Employee>();
		//Getting the connection object
		Connection connection = ConnectionFactory.getConnection();
		try {
			//Creating the prepared statement query
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee");
			//Executing the query
			ResultSet result = statement.executeQuery();
			
			//Iterating over the result set
			while(result.next()) {
				Employee employee = new Employee();
				employee.setId(result.getInt("idemployee"));
				employee.setName(result.getString("name"));
				employee.setCity(result.getString("city"));
				employee.setAge(result.getInt("age"));
				employee.setSalary(result.getInt("salary"));
				
				listEmployee.add(employee);
			}
			
			result.close();
			statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEmployee;
	}
	
	/**
	 * To delete the employee record by its id
	 * @param id - The employee id to be deleted
	 * @return - true if the record is deleted successfully else false
	 */
	public boolean deleteEmployee(int id) {
		//Getting the connection object
		Connection connection = ConnectionFactory.getConnection();
		try {
			//Creating the prepared statement query
			PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE idemployee = ?");
			//Setting the parameters to the prepared statement
			statement.setInt(1, id);

			//Executing the query
			int rowsAffected = statement.executeUpdate();
			statement.close();
			
			if(rowsAffected > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * To insert a record for the employee
	 * @param employee - The employee object
	 * @return - true if the record is created else false
	 */
	public int insertEmployee(Employee employee) {
		//Getting the connection object
		Connection connection = ConnectionFactory.getConnection();
		try {
			//Creating the prepared statement query
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO employee (name, city, age, salary) "
					+ "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			//Setting the parameters to the prepared statement
			statement.setString(1, employee.getName());
			statement.setString(2, employee.getCity());
			statement.setInt(3, employee.getAge());
			statement.setInt(4, employee.getSalary());
			System.out.println(statement);
			//Executing the query
			statement.executeUpdate();
			
			//Fetching the auto generated key to be used by tables also
			ResultSet rs = statement.getGeneratedKeys();
			int lastInsertedID = 0;
            if(rs.next()) {
                lastInsertedID = rs.getInt(1);
            }
			statement.close();
			
			return lastInsertedID;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * To get EmployeeDAO Object
	 * @return - The EmployeeDAO object
	 */
	public static EmployeeDAO getObject() {
		//Checking if facade object already exists or not
		if(employeeDAO == null) {
			employeeDAO = new EmployeeDAO();
		}
		return employeeDAO;
	}
	
	/**
	 * To close EmployeeDAO object
	 */
	public static void closeEmployeeDAO() {
		ConnectionFactory.closeConnection();
	}
}
