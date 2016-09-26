/**
 * Assignment 1
 * Data Access Object Class
 * To interact with the database
 * using the Singleton Pattern
 * @author Arpit Pittie
 */
package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarDAO {
	
	private static CarDAO carDAOObject = null;	//CarDAO object for singleton pattern
	private static PreparedStatement statement;	//Prepared statement object
	
	/**
	 * Constructor to implement the singleton pattern
	 */
	private CarDAO() {
		
	}
	
	/**
	 * To get the available car list
	 * @return The result set containing the cars details
	 */
	public ResultSet getCarList() {
		try {
			//Getting the connection object
			Connection connection = ConnectionFactory.getConnection();
			//Creating the prepared statement query
			statement = connection.prepareStatement(
					"SELECT * FROM vehiclevo v INNER JOIN carvo c ON c.id = v.id");
			
			//Executing the query
			ResultSet result = statement.executeQuery();
			
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getCarDetailsById(int id) {
		try {
			//Getting the connection object
			Connection connection = ConnectionFactory.getConnection();
			//Creating the prepared statement query
			PreparedStatement statement = connection.prepareStatement(
					"SELECT * FROM vehiclevo v INNER JOIN carvo c ON c.id = v.id WHERE c.id = ?");
			statement.setInt(1, id);
			
			//Executing the query
			ResultSet result = statement.executeQuery();
			
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getCarDetailsByMake(String id) {
		try {
			//Getting the connection object
			Connection connection = ConnectionFactory.getConnection();
			//Creating the prepared statement query
			PreparedStatement statement = connection.prepareStatement(
					"SELECT * FROM vehiclevo v INNER JOIN carvo c ON c.id = v.id WHERE v.make = ?");
			//Setting the parameters to the prepared statement
			statement.setString(1, id);
			
			//Executing the query
			ResultSet result = statement.executeQuery();
			
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insertCarDetails(CarVO carVo, CarTO carTo) {
		//Getting the connection object
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement;
		
		try {
			//Creating the prepared statement query
			statement = connection.prepareStatement(
					"INSERT INTO vehiclevo "
					+ "(make, model, engineInCC, fuelCapacity, milage, price, roadTax) VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			//Setting the parameters to the prepared statement
			statement.setString(1, carVo.getMake());
			statement.setString(2, carVo.getModel());
			statement.setInt(3, carVo.getEngineInCC());
			statement.setDouble(4, carVo.getFuelCapacity());
			statement.setDouble(5, carVo.getMilage());
			statement.setDouble(6, carVo.getPrice());
			statement.setDouble(7, carVo.getRoadTax());
			
			//Executing the query
			statement.executeUpdate();
			
			//Fetching the auto generated key to be used by tables also
			ResultSet rs = statement.getGeneratedKeys();
			int lastInsertedID = 0;
            if(rs.next()) {
                lastInsertedID = rs.getInt(1);
            }
			statement.close();
			
			//Creating the prepared statement query
			statement = connection.prepareStatement(
					"INSERT INTO car "
					+ "(id, createdBy, createdTime, updatedBy, updatedTime) VALUES "
					+ "(?, ?, ?, ?, ?)");
			//Setting the parameters to the prepared statement
			statement.setInt(1, lastInsertedID);
			statement.setString(2, carTo.getCreatedBy());
			statement.setString(3, carTo.getCreatedTime());
			statement.setString(4, carTo.getUpdatedBy());
			statement.setString(5, carTo.getUpdatedTime());
			
			//Executing the query
			statement.executeUpdate();
			statement.close();
			
			//Creating the prepared statement query
			statement = connection.prepareStatement(
					"INSERT INTO carvo "
					+ "(id, ac, powerSteering, accessoryKit) VALUES "
					+ "(?, ?, ?, ?)");
			//Setting the parameters to the prepared statement
			statement.setInt(1, lastInsertedID);
			statement.setString(2, carVo.getAc());
			statement.setString(3, carVo.getpowerSteering());
			statement.setString(4, carVo.getAccessoryKit());
			
			//Executing the query
			statement.executeUpdate();
			statement.close();
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateCarDetails(CarVO carVo, CarTO carTo) {
		//Getting the connection object
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement;
		
		try {
			//Creating the prepared statement query
			statement = connection.prepareStatement(
					"UPDATE car SET "
					+ "updatedBy = ?, updatedTime = ? "
					+ "WHERE id = ?");
			//Setting the parameters to the prepared statement
			statement.setString(1, carTo.getUpdatedBy());
			statement.setString(2, carTo.getUpdatedTime());
			statement.setInt(3, carTo.getId());
			
			//Executing the query
			statement.executeUpdate();
			statement.close();
			
			//Creating the prepared statement query
			statement = connection.prepareStatement(
					"UPDATE vehiclevo SET "
					+ "make = ?, model = ?, engineInCC = ?, fuelCapacity = ?, milage = ?, price = ?, roadTax = ? "
					+ "WHERE id = ?");
			//Setting the parameters to the prepared statement
			statement.setString(1, carVo.getMake());
			statement.setString(2, carVo.getModel());
			statement.setInt(3, carVo.getEngineInCC());
			statement.setDouble(4, carVo.getFuelCapacity());
			statement.setDouble(5, carVo.getMilage());
			statement.setDouble(6, carVo.getPrice());
			statement.setDouble(7, carVo.getRoadTax());
			statement.setInt(8, carVo.getId());

			//Executing the query
			statement.executeUpdate();
			statement.close();
			
			//Creating the prepared statement query
			statement = connection.prepareStatement(
					"UPDATE carvo SET "
					+ "ac = ?, powerSteering = ?, accessoryKit = ? "
					+ "WHERE id = ?");
			//Setting the parameters to the prepared statement
			statement.setString(1, carVo.getAc());
			statement.setString(2, carVo.getpowerSteering());
			statement.setString(3, carVo.getAccessoryKit());
			statement.setInt(4, carVo.getId());
			
			//Executing the query
			statement.executeUpdate();
			statement.close();
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * To get the carDAO object
	 * @return - The CarDAO object
	 */
	public static CarDAO getObject() {
		//Checking if facade object already exists or not
		if(carDAOObject == null) {
			carDAOObject = new CarDAO();
		}
		return carDAOObject;
	}
	
	/**
	 * To close the carDAO object
	 */
	public static void closeCarDAO() {
		try {
			statement.close();
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			try {
				statement.close();
				ConnectionFactory.closeConnection();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
