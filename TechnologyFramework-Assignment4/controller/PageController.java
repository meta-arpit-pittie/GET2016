/**
 * Assignment 1
 * To map different URL for the pages
 * @author Arpit Pittie
 */
package com.hibernate.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernate.model.CarVO;
import com.hibernate.service.CarFacade;

@Controller
public class PageController {
	
	@Autowired
	private CarFacade carFacade;	//To get the CarFacade object
	
	@Autowired
	private ApplicationContext context;	//To get the beans
	
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
	 * @param request - The request with the form data
	 * @return - The page name to render
	 */
	@RequestMapping("savedetails")
	public String showSaveDetailsPage(HttpServletRequest request) {
		CarVO carVO = context.getBean("carVO", CarVO.class);
		
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
		
		carVO.setUpdatedBy("root");
		carVO.setUpdatedTime(currentDate);
		
		//Checking that the purpose for form was to edit or create a record
		if(request.getParameter("id") != null && !request.getParameter("id").equals("")) {
			carVO.setId(Integer.parseInt(request.getParameter("id")));
		} else {
			carVO.setCreatedBy("root");
			carVO.setCreatedTime(currentDate);
		}
		
		
		boolean result = carFacade.addUpdateCarDetails(carVO);
		
		//To decide which page to render
		if(result) {
			return "listCar";
		} else {
			return "carCreate";
		}
	}
}
