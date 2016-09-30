/**
 * Assignment 2
 * Servlet Controller class 
 * To get the list of cars in the database and set the model accordingly
 * Calling the appropriate jsp page for it
 * @author Arpit Pittie
 */
package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.CarFacade;
import com.model.CarVO;

@Controller
@RequestMapping("/pages/")
public class CarsController {
	
	@RequestMapping(value="/carlist", method=RequestMethod.GET)
	public @ResponseBody Response showCarList() {
		//Getting the object of Car Facade Class
		CarFacade facade = CarFacade.getFacade();
		
		//Getting the list of cars
		List<CarVO> carList = facade.getCarList();
		
		try {
			CarFacade.closeFacade();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Response(carList);
	}
	
	@RequestMapping(value="/cardetails", method=RequestMethod.GET)
	public @ResponseBody Response showCarDetails(@RequestParam("id") String id) {
		//Getting the object of Car Facade Class
		CarFacade facade = CarFacade.getFacade();
		
		//Getting the car details
		CarVO car = facade.getCarDetailsById(Integer.parseInt(id));
		
		try {
			CarFacade.closeFacade();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Response(car);
	}
}
