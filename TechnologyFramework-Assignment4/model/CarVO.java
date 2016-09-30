/**
 * Assignment 1
 * Class to give the Car View Object to the end client
 * @author Arpit Pittie
 */
package com.hibernate.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CarVO {

	private int id;
	private String createdBy;
	private String createdTime;
	private String updatedBy;
	private String updatedTime;
	private String make;
	private String model;
	private int engineInCC;
	private double fuelCapacity;
	private double milage;
	
	private double price;
	private double roadTax;
	private String ac;
	private String powerSteering;
	private String accessoryKit;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getCreatedTime() {
		return createdTime;
	}
	
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	
	public String getUpdatedBy() {
		return updatedBy;
	}
	
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public String getUpdatedTime() {
		return updatedTime;
	}
	
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getEngineInCC() {
		return engineInCC;
	}
	
	public void setEngineInCC(int engineInCC) {
		this.engineInCC = engineInCC;
	}
	
	public double getFuelCapacity() {
		return fuelCapacity;
	}
	
	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}
	
	public double getMilage() {
		return milage;
	}
	
	public void setMilage(double milage) {
		this.milage = milage;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getRoadTax() {
		return roadTax;
	}
	
	public void setRoadTax(double roadTax) {
		this.roadTax = roadTax;
	}
	
	public String getAc() {
		return ac;
	}
	
	public void setAc(String ac) {
		this.ac = ac;
	}
	
	public String getPowerSteering() {
		return powerSteering;
	}
	
	public void setPowerSteering(String powerSteering) {
		this.powerSteering = powerSteering;
	}
	
	public String getAccessoryKit() {
		return accessoryKit;
	}
	
	public void setAccessoryKit(String accessoryKit) {
		this.accessoryKit = accessoryKit;
	}
}
