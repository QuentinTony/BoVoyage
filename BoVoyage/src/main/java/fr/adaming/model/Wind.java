package fr.adaming.model;

import java.io.Serializable;

public class Wind implements Serializable {
	
	private double speed;
	private double deg;
	public Wind() {
		super();
	}
	public Wind(double speed, double deg) {
		super();
		this.speed = speed;
		this.deg = deg;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getDeg() {
		return deg;
	}
	public void setDeg(double deg) {
		this.deg = deg;
	}
	
	
	

}
