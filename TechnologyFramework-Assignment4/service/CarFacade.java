/**
 * Assignment 1
 * Class to provide APIs for accessing the database
 * @author Arpit Pittie
 */
package com.hibernate.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.hibernate.model.CarModel;
import com.hibernate.model.CarVO;

@Component("carFacade")
@Transactional
public class CarFacade {
	
	@Autowired
	private CarDAO carDAO = new CarDAO();	//To get the CarDAO Object
	
	@Autowired
	private ApplicationContext context;	//To get the beans
	
	/**
	 * To get all the available cars
	 * @return - The list of CarVO containing all the cars
	 */
	public List<CarVO> getCarList() {
		List<CarVO> listCar = new ArrayList<CarVO>();
		
		//Getting the car list
		List<CarModel> listCarModel = carDAO.getCarList();
		
		//To copy the data from the ORM object into the VO object
		for(CarModel cm : listCarModel) {
			CarVO car = context.getBean("carVO", CarVO.class);
			car.setId(cm.getId());
			car.setMake(cm.getMake());
			car.setModel(cm.getModel());
			
			listCar.add(car);
		}
				
		return listCar;
	}
	
	/**
	 * To get the car details based on its id
	 * @param id - The id of the car to get the details
	 * @return - The CarVO object containing all the details of the car
	 */
	public CarVO getCarDetailsById(int id) {
		//Getting the car details
		CarModel carModel = carDAO.getCarDetailsById(id);
		
		CarVO car = context.getBean("carVO", CarVO.class);
		
		//Copying the data from ORM Object to VO Object
		BeanUtils.copyProperties(carModel, car);
			
		return car;
	}
	
	/**
	 * To get the car details based on the make
	 * @param make - The make of the cars whose details we want
	 * @return - The list of cars for the particular make
	 */
	public List<CarVO> getCarDetailsByMake(String make) {
		List<CarVO> listCar = new ArrayList<CarVO>();
		
		//Getting the car details
		List<CarModel> carModelList = carDAO.getCarDetailsByMake(make);
		
		//To copy the data from the ORM object into the VO object
		for(CarModel cm : carModelList) {
			CarVO car = context.getBean("carVO", CarVO.class);
			BeanUtils.copyProperties(cm, car);
			
			listCar.add(car);
		}
				
		return listCar;
	}
	
	/**
	 * To update or create a car
	 * @param carvo - The CarVO object having all the details to be updated or for creation
	 * @return - True if the process is successful else false
	 */
	public boolean addUpdateCarDetails(CarVO carvo) {
		//Getting the ORM Object
		CarModel carModel = context.getBean("carModel", CarModel.class);
		
		//Copying the data from VO Object to ORM Object
		BeanUtils.copyProperties(carvo, carModel);
		
		//Checking if the query is to update the details or for creation of new record
		if(carvo.getId() == 0) {
			return carDAO.insertCarDetails(carModel);
		} else {
			return carDAO.updateCarDetails(carModel);
		}
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

}
