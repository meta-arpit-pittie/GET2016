/**
 * Assignment 1
 * Class to map the relational table in the database
 * Used for ORM in the hibernate
 * @author Arpit Pittie
 */
package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "car")
public class CarModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_time")
	private String createdTime;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@Column(name = "updated_time")
	private String updatedTime;
	
	@Column(name = "make")
	private String make;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "engine_in_cc")
	private int engineInCC;
	
	@Column(name = "fuel_capacity")
	private double fuelCapacity;
	
	@Column(name = "milage")
	private double milage;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "road_tax")
	private double roadTax;
	
	@Column(name = "ac")
	private String ac;
	
	@Column(name = "power_steering")
	private String powerSteering;
	
	@Column(name = "accessory_kit")
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
