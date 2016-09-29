/**
 * Assignment 1
 * Facade layer for Car Vehicle
 * Based on singleton class model
 * @author Arpit Pittie
 */
package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CarFacade {

	private static CarFacade facade = null;	//Facade object for singleton pattern
		
	/**
	 * Constructor to implement the singleton pattern
	 */
	private CarFacade() {
		
	}
	
	/**
	 * To get the available car list
	 * @return The list of CarVO objects containing the make and models of the cars
	 */
	public List<CarVO> getCarList() {
		List<CarVO> carVOList = new ArrayList<CarVO>();
		CarDAO carDAO = CarDAO.getObject();
		ResultSet result = carDAO.getCarList();
		
		//Getting the bean object
		ApplicationContext context = new ClassPathXmlApplicationContext("beanContext.xml");
		CarVO car;
		
		try {
			//Iterating over the result set
			while(result.next()) {
				car = context.getBean("carVO", CarVO.class);
				car.setId(result.getInt("id"));
				car.setMake(result.getString("make"));
				car.setModel(result.getString("model"));
				
				carVOList.add(car);
			}
			((ClassPathXmlApplicationContext)context).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carVOList;
	}
	
	/**
	 * To get the CarVO object based on the id
	 * @param id - The id of the car whose details needs to be fetched
	 * @return - The object of CarVO class
	 */
	public CarVO getCarDetailsById(int id) {
		CarDAO carDAO = CarDAO.getObject();
		//Getting the result set
		ResultSet result = carDAO.getCarDetailsById(id);
		
		//Getting the bean object
		ApplicationContext context = new ClassPathXmlApplicationContext("beanContext.xml");
		CarVO car = context.getBean("carVO", CarVO.class);
		
		try {
			//Iterating over the result set
			while(result.next()) {
				//Saving the details of car in the bean object
				car.setId(result.getInt("id"));
				car.setMake(result.getString("make"));
				car.setModel(result.getString("model"));
				car.setEngineInCC(result.getInt("engineInCC"));
				car.setFuelCapacity(result.getDouble("fuelCapacity"));
				car.setMilage(result.getDouble("milage"));
				car.setPrice(result.getDouble("price"));
				car.setRoadTax(result.getDouble("roadTax"));		
				
				car.setAc(result.getString("ac"));
				car.setPowerSteering(result.getString("powerSteering"));
				car.setAccessoryKit(result.getString("accessoryKit"));
			}
			((ClassPathXmlApplicationContext)context).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}
	
	/**
	 * To get the list of cars based upon their make
	 * @param make - The make of the car whose details needs to be fetched
	 * @return - The list of CarVO objects containing information about the crs having specific make
	 */
	public List<CarVO> getCarDetailsByMake(String make) {
		List<CarVO> carVOList = new ArrayList<CarVO>();
		CarDAO carDAO = CarDAO.getObject();
		//Getting the result set
		ResultSet result = carDAO.getCarDetailsByMake(make);
		
		//Getting the bean object
		ApplicationContext context = new ClassPathXmlApplicationContext("beanContext.xml");
		CarVO car;
		
		try {
			//Iterating over the result set
			while(result.next()) {
				//Saving the details of car in the bean object
				car = context.getBean("carVO", CarVO.class);
				car.setId(result.getInt("id"));
				car.setMake(result.getString("make"));
				car.setModel(result.getString("model"));
				car.setEngineInCC(result.getInt("engineInCC"));
				car.setFuelCapacity(result.getDouble("fuelCapacity"));
				car.setMilage(result.getDouble("milage"));
				car.setPrice(result.getDouble("price"));
				car.setRoadTax(result.getDouble("roadTax"));		
				
				car.setAc(result.getString("ac"));
				car.setPowerSteering(result.getString("powerSteering"));
				car.setAccessoryKit(result.getString("accessoryKit"));
				
				//Adding the object to the list
				carVOList.add(car);
			}
			((ClassPathXmlApplicationContext)context).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carVOList;
	}
	
	/**
	 * To update or insert the car details
	 * @param carvo - The CarVO object containing the cars details
	 * @param carto - The CarTO object containing the cars metadata details
	 * @return - True if the operation is successful else false
	 */
	public boolean addUpdateCarDetails(CarVO carvo, CarTO carto) {
		CarDAO carDAO = CarDAO.getObject();
		if(carto.getCreatedTime() != null) {
			return carDAO.insertCarDetails(carvo, carto);
		} else {
			return carDAO.updateCarDetails(carvo, carto);
		}
	}
	
	/**
	 * To get the facade object
	 * @return - The Facade object
	 */
	public static CarFacade getFacade() {
		//Checking if facade object already exists or not
		if(facade == null) {
			ApplicationContext context = new ClassPathXmlApplicationContext("beanContext.xml");
			
			//Getting the facade object
			facade = context.getBean("carFacade", CarFacade.class);
			((ClassPathXmlApplicationContext)context).close();
		}
		return facade;
	}
	
	/**
	 * To close the facade object
	 */
	public static void closeFacade() {
		CarDAO.closeCarDAO();
	}
}
