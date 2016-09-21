/**
 * Assignment 1
 * To implement the REST Web Services
 * @author Arpit Pittie
 */
package com.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
public class RestEmployeeServices {
	
	/**
	 * Web Service to get employee by its id
	 * @param id - The id of the employee
	 * @return - Response of the web service
	 */
	@GET
	@Path("/getEmployeeById")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeById(@QueryParam("id") int id) {
		//Getting employee list
		List<Employee> employeeList = EmployeeDAO.getObject().getEmployeeById(id);
		//Converting list into a generic entity to send it over response
		GenericEntity<List<Employee>> generic = new GenericEntity<List<Employee>>(employeeList){};
		//Sending the response
  	    return Response.ok( generic ).build();
	}
	
	/**
	 * Web service to get employee by its name
	 * @param name - The name of the employee
	 * @return - Response of the web service
	 */
	@GET
	@Path("/getEmployeeByName")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeByName(@QueryParam("name") String name) {
		//Getting employee list
		List<Employee> employeeList = EmployeeDAO.getObject().getEmployeeByName(name);
		//Converting list into a generic entity to send it over response
		GenericEntity<List<Employee>> generic = new GenericEntity<List<Employee>>(employeeList){};
		//Sending the response
  	    return Response.ok( generic ).build();
	}
	
	/**
	 * Web Service to get details of all the employees
	 * @return Response of the web service
	 */
	@GET
	@Path("/getEmployees")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployees() {
		//Getting employee list
		List<Employee> employeeList = EmployeeDAO.getObject().getEmployees();
		//Converting list into a generic entity to send it over response
		GenericEntity<List<Employee>> generic = new GenericEntity<List<Employee>>(employeeList){};
		//Sending the response
  	    return Response.ok( generic ).build();
	}
	
	/**
	 * Web service to delete employee record by id
	 * @param id - The id of the employee
	 * @return - Result if the record is successfully deleted or not
	 */
	@DELETE
	@Path("/deleteEmployee")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployees(@QueryParam("id") int id) {
		boolean result = EmployeeDAO.getObject().deleteEmployee(id);
		if(result) {
			return "Employee record deleted successfully";
		} else {
			return "Employee record not found";
		}
	}
	
	/**
	 * Web service to create a employee record
	 * @param employee - The employee object to be inserted
	 * @return - Result if the record is successfully added or not
	 */
	@POST
	@Path("/insertEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertEmployees(Employee employee) {
		int result = EmployeeDAO.getObject().insertEmployee(employee);
		if(result != 0) {
			return "Employee record created successfully";
		} else {
			return "Error in employee details";
		}
	}
}
