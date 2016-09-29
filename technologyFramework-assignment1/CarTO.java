/**
 * Assignment 1
 * Bean class for car metadata
 * @author Arpit Pittie
 */
package com.model;

import org.springframework.stereotype.Component;

@Component
public class CarTO {

	private int id;
	private String createdBy;
	private String createdTime;
	private String updatedBy;
	private String updatedTime;
	
	public CarTO() {
		
	}
	
	public CarTO(int id, String createdBy, String createdTime, String updatedBy, String updatedTime) {
		this.id = id;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.updatedBy = updatedBy;
		this.updatedTime = updatedTime;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	
	public String getCreatedTime() {
		return createdTime;
	}
	
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public String getUpdatedBy() {
		return updatedBy;
	}
	
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	public String getUpdatedTime() {
		return updatedTime;
	}
}
