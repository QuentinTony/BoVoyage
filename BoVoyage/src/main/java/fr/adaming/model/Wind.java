package fr.adaming.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Wind implements Serializable {
	
	private double speed;
	private double deg;
	@JsonIgnore
	private Object gust;
	
	
	public Object getGust() {
		return gust;
	}
	public void setGust(Object gust) {
		this.gust = gust;
	}
	public Wind(double speed, double deg, Object gust) {
		super();
		this.speed = speed;
		this.deg = deg;
		this.gust = gust;
	}
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
