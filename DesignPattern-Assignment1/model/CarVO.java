/**
 * Assignment 1
 * Bean class for cars
 * @author Arpit Pittie
 */
package com.model;

public class CarVO extends VehicleVO {

	private int id;
	private String ac;
	private String powerSteering;
	private String accessoryKit;
	
	public CarVO() {
		
	}
	
	public CarVO(int id, String ac, String powerSteering, String accessoryKit) {
		this.id = id;
		this.ac = ac;
		this.powerSteering = powerSteering;
		this.accessoryKit = accessoryKit;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setAc(String ac) {
		this.ac = ac;
	}
	
	public String getAc() {
		return ac;
	}
	
	public void setPowerSteering(String powerSteering) {
		this.powerSteering = powerSteering;
	}
	
	public String getpowerSteering() {
		return powerSteering;
	}
	
	public void setAccessoryKit(String accessoryKit) {
		this.accessoryKit = accessoryKit;
	}
	
	public String getAccessoryKit() {
		return accessoryKit;
	}
}
