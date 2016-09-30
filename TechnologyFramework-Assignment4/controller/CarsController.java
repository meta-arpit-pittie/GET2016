/**
 * Assignment 2
 * Servlet Controller class 
 * To get the list of cars in the database and set the model accordingly
 * Calling the appropriate jsp page for it
 * @author Arpit Pittie
 */
package com.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hibernate.model.CarVO;
import com.hibernate.service.CarFacade;

@Controller
@RequestMapping("/pages/")
public class CarsController {
	
	@Autowired
	private CarFacade carFacade;	//To get the CarFacae object
	
	/**
	 * To get all the cars list
	 * @return - The list of cars wrapped in a Response Object
	 */
	@RequestMapping(value="/carlist", method=RequestMethod.GET)
	public @ResponseBody Response showCarList() {
		
		//Getting the list of cars
		List<CarVO> carList = carFacade.getCarList();
		
		return new Response(carList);
	}
	
	/**
	 * To get all the details of a car
	 * @param id - The id of the car to get the details
	 * @return - The car details wrapped in a Response Object
	 */
	@RequestMapping(value="/cardetails", method=RequestMethod.GET)
	public @ResponseBody Response showCarDetails(@RequestParam("id") String id) {
		
		//Getting the car details
		CarVO car = carFacade.getCarDetailsById(Integer.parseInt(id));
		
		return new Response(car);
	}
}
