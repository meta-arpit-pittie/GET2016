/**
 * Assignment 1
 * To implement the REST Web Services
 * @author Arpit Pittie
 */
package com.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.catalina.filters.CorsFilter;

@Path("/customer")
public class RestCustomerServices {
		
	/**
	 * Web Service to get details of all the employees
	 * @return Response of the web service
	 */
	@GET
	@Path("/getCustomers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomers() {
		//Getting customer list
		List<Customer> employeeList = CustomerDAO.getObject().getCustomers();
		//Converting list into a generic entity to send it over response
		GenericEntity<List<Customer>> generic = new GenericEntity<List<Customer>>(employeeList){};
		//Sending the response
  	    return Response.ok( generic ).header("Access-Control-Allow-Origin", CorsFilter.DEFAULT_ALLOWED_ORIGINS).build();
	}
	
	/**
	 * Web service to delete customer record by id
	 * @param id - The id of the customer
	 * @return - Result if the record is successfully deleted or not
	 */
	@GET
	@Path("/deleteCustomer")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCustomers(@QueryParam("id") int id) {
		boolean result = CustomerDAO.getObject().deleteCustomer(id);
		if(result) {
			return "customer record deleted successfully";
		} else {
			return "customer record not found";
		}
	}
	
	/**
	 * Web service to create a customer record
	 * @param customer - The customer object to be inserted
	 * @return - Result if the record is successfully added or not
	 */
	@POST
	@Path("/insertCustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertCustomers(Customer customer) {
		int result;
		if(customer.getId() != 0) {
			result = CustomerDAO.getObject().updateCustomer(customer);
		} else {
			result = CustomerDAO.getObject().insertCustomer(customer);
		}
		
		
		if(result != 0) {
			return "customer record created successfully with ID = "+result;
		} else {
			return "Error in customer details";
		}
	}
}
