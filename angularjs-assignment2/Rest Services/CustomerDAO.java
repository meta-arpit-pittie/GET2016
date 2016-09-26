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

public class CustomerDAO {
	
	private static CustomerDAO customerDAO = null;	//CustomerDAO for implementing singleton pattern
	
	private CustomerDAO() {
		
	}
	
	/**
	 * To get all the customers
	 * @return - List of all customers
	 */
	public List<Customer> getCustomers() {
		List<Customer> listCustomer = new ArrayList<Customer>();
		//Getting the connection object
		Connection connection = ConnectionFactory.getConnection();
		try {
			//Creating the prepared statement query
			PreparedStatement statement = connection.prepareStatement("SELECT idcustomer, firstName, lastName, "
					+ "email, address, noOrders FROM customer");
			//Executing the query
			ResultSet result = statement.executeQuery();
			
			//Iterating over the result set
			while(result.next()) {
				Customer customer = new Customer();
				customer.setId(result.getInt("idcustomer"));
				customer.setFirstName(result.getString("firstName"));
				customer.setLastName(result.getString("lastName"));
				customer.setEmail(result.getString("email"));
				customer.setAddress(result.getString("address"));
				customer.setNumberOfOrders(result.getInt("noOrders"));
				
				listCustomer.add(customer);
			}
			
			result.close();
			statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCustomer;
	}
	
	/**
	 * To delete the customer record by its id
	 * @param id - The customer id to be deleted
	 * @return - true if the record is deleted successfully else false
	 */
	public boolean deleteCustomer(int id) {
		//Getting the connection object
		Connection connection = ConnectionFactory.getConnection();
		try {
			//Creating the prepared statement query
			PreparedStatement statement = connection.prepareStatement("DELETE FROM customer WHERE idcustomer = ?");
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
	 * To insert a record for the customer
	 * @param customer - The customer object
	 * @return - true if the record is created else false
	 */
	public int insertCustomer(Customer customer) {
		//Getting the connection object
		Connection connection = ConnectionFactory.getConnection();
		try {
			//Creating the prepared statement query
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO customer (firstName, lastName, email, address, noOrders) "
					+ "VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			//Setting the parameters to the prepared statement
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getEmail());
			statement.setString(4, customer.getAddress());
			statement.setInt(5, customer.getNumberOfOrders());
			
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
	
	public int updateCustomer(Customer customer) {
		//Getting the connection object
		Connection connection = ConnectionFactory.getConnection();
		try {
			//Creating the prepared statement query
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE customer SET firstName = ?, lastName = ?, email = ?, "
					+ "address = ?, noOrders = ? WHERE idcustomer = ?");
			//Setting the parameters to the prepared statement
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getEmail());
			statement.setString(4, customer.getAddress());
			statement.setInt(5, customer.getNumberOfOrders());
			statement.setInt(6, customer.getId());
			System.out.println(statement);
			//Executing the query
			int result = statement.executeUpdate();
			
			statement.close();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * To get CustomerDAO Object
	 * @return - The CustomerDAO object
	 */
	public static CustomerDAO getObject() {
		//Checking if facade object already exists or not
		if(customerDAO == null) {
			customerDAO = new CustomerDAO();
		}
		return customerDAO;
	}
	
	/**
	 * To close CustomerDAO object
	 */
	public static void closeCustomerDAO() {
		ConnectionFactory.closeConnection();
	}
}
