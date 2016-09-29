/**
 * Assignment 1
 * To map different URL for the pages
 * @author Arpit Pittie
 */
package com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.CarFacade;
import com.model.CarTO;
import com.model.CarVO;

@Controller
public class PageController {
	
	/**
	 * For mapping the home page
	 * @return - The page name to render
	 */
	@RequestMapping("/")
	public String showIndexPage() {
		return "index";
	}
	
	/**
	 * For mapping the car list page
	 * @return - The page name to render
	 */
	@RequestMapping("listCar")
	public String showCarListPage() {
		return "listCar";
	}
	
	/**
	 * For mapping the car details page
	 * @param id - The id of the car to get the details
	 * @param model - The model to set the id into
	 * @return - The page name to render
	 */
	@RequestMapping("cardetails")
	public String showCarDetailsPage(@RequestParam("id") String id, ModelMap model) {
		model.addAttribute("id", id);
		return "carDetails";
	}
	
	/**
	 * For mapping the car edit page
	 * @param id - The id of the car to get the details
	 * @param model - The model to set the id into
	 * @return - The page name to render
	 */
	@RequestMapping("caredit")
	public String showCarEditPage(@RequestParam("id") String id, ModelMap model) {
		model.addAttribute("id", id);
		return "form";
	}
	
	/**
	 * For mapping the car create page
	 * @return - The page name to render
	 */
	@RequestMapping("carCreate")
	public String showCarCreatePage() {
		return "form";
	}
	
	/**
	 * For mapping the car edit and submit page data
	 * @param request - The request with tthe form data
	 * @return - The page name to render
	 */
	@RequestMapping("savedetails")
	public String showSaveDetailsPage(HttpServletRequest request) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanContext.xml");
		CarVO carVO = context.getBean("carVO", CarVO.class);
		CarTO carTO = context.getBean("carTO", CarTO.class);
		
		//Getting the current date and time
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String currentDate = dateFormat.format(cal.getTime());
		
		//Setting the form values to the bean object
		carVO.setMake(request.getParameter("make"));
		carVO.setModel(request.getParameter("model"));
		carVO.setEngineInCC(Integer.parseInt(request.getParameter("engine")));
		carVO.setFuelCapacity(Double.parseDouble(request.getParameter("fuel")));
		carVO.setMilage(Double.parseDouble(request.getParameter("milage")));
		carVO.setPrice(Double.parseDouble(request.getParameter("price")));
		carVO.setRoadTax(Double.parseDouble(request.getParameter("tax")));
		
		carVO.setAc(request.getParameter("ac"));
		carVO.setPowerSteering(request.getParameter("steering"));
		carVO.setAccessoryKit(request.getParameter("kit"));
		
		carTO.setUpdatedBy("root");
		carTO.setUpdatedTime(currentDate);
		System.out.println(request.getParameter("id")+"safs");
		//Checking that the purpose for form was to edit or create a record
		if(request.getParameter("id") != null && !request.getParameter("id").equals("")) {
			carVO.setId(Integer.parseInt(request.getParameter("id")));
		} else {
			carTO.setCreatedBy("root");
			carTO.setCreatedTime(currentDate);
		}
		
		//Getting the object of Car Facade Class
		CarFacade facade = CarFacade.getFacade();
		
		boolean result = facade.addUpdateCarDetails(carVO, carTO);
		
		try {
			((ClassPathXmlApplicationContext)context).close();
			CarFacade.closeFacade();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//To decide which page to render
		if(result) {
			return "listCar";
		} else {
			return "carCreate";
		}
	}
}
