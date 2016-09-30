/**
 * Assignment 1
 * Class to interact with the database
 * @author Arpit Pittie
 */
package com.hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.model.CarModel;

@Repository("carDAO")
@Transactional
public class CarDAO {

	@Autowired
	private SessionFactory sessionFactory;	//To create a session for the database operation

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * To get all the cars in a list
	 * @return - A list of cars
	 */
	@SuppressWarnings("unchecked")
	public List<CarModel> getCarList() {
		try {
			//Creating a new session for database interaction
			Session session = sessionFactory.openSession();
			
			//Creating a Criteria query for querying the database
			Criteria criteriaQuery = session.createCriteria(CarModel.class);
			
			return criteriaQuery.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * To get the car details based on the id 
	 * @param id - The id of the car to get the details
	 * @return - The car model containing all the details
	 */
	public CarModel getCarDetailsById(int id) {
		try {
			//Creating a new session for database interaction
			Session session = sessionFactory.openSession();
			
			//Creating a Criteria query for querying the database
			Criteria criteriaQuery = session.createCriteria(CarModel.class);
			
			//Adding a restriction on the query to fetch the record
			criteriaQuery.add(Restrictions.eq("id", id));
			
			return (CarModel)criteriaQuery.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * To get the car details based on the make
	 * @param make - The make of the car to get the details
	 * @return - The list of cars having the given make
	 */
	@SuppressWarnings("unchecked")
	public List<CarModel> getCarDetailsByMake(String make) {
		try {
			//Creating a new session for database interaction
			Session session = sessionFactory.openSession();
			
			//Creating a Criteria query for querying the database
			Criteria criteriaQuery = session.createCriteria(CarModel.class);
			
			//Adding a restriction on the query to fetch the record
			criteriaQuery.add(Restrictions.eq("make", make));
			
			return criteriaQuery.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * To create a new record for the car
	 * @param car - The CarModel Object containing the fields 
	 * 				which need to be inserted into the database
	 * @return - True if the operation is successful else false
	 */
	public boolean insertCarDetails(CarModel car) {
		try {
			//Creating a new session for database interaction
			Session session = sessionFactory.openSession();
			
			//Starting a new transaction
			session.beginTransaction();
			//inserting the car model using the orm into the table
			session.save(car);
			//Committing the transaction
			session.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * To update a record for the car
	 * @param car - The CarModel Object containing the fields 
	 * 				which need to be updated in the database
	 * @return - True if the operation is successful else false
	 */
	public boolean updateCarDetails(CarModel car) {
		try {
			//Creating a new session for database interaction
			Session session = sessionFactory.openSession();
			
			//Getting the object of the car to update
			CarModel objectToUpdate = (CarModel) session.get(CarModel.class, car.getId());
			//Starting a new transaction
			session.beginTransaction();
			
			//Updating the fields to be updated
			objectToUpdate.setMake(car.getMake());
			objectToUpdate.setModel(car.getModel());
			objectToUpdate.setEngineInCC(car.getEngineInCC());
			objectToUpdate.setFuelCapacity(car.getFuelCapacity());
			objectToUpdate.setMilage(car.getMilage());
			objectToUpdate.setPrice(car.getPrice());
			objectToUpdate.setRoadTax(car.getRoadTax());
			objectToUpdate.setAc(car.getAc());
			objectToUpdate.setAccessoryKit(car.getAccessoryKit());
			objectToUpdate.setPowerSteering(car.getPowerSteering());
			
			//Committing the transaction
			session.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
