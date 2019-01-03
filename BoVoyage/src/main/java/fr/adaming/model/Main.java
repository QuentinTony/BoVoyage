package fr.adaming.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@XmlRootElement
public class Main implements Serializable{
	
	private Double temp;
	private long pressure;
	private long humidity;
	private Double temp_min;
	private Double temp_max;
	
	@JsonIgnore
	private Object sea_level;
	
	@JsonIgnore
	private Object grnd_level;
	
	public Main() {
		super();
	}
	public Main(Double temp, long pressure, long humidity, Double temp_min, Double temp_max) {
		super();
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
	}
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public long getPressure() {
		return pressure;
	}
	public void setPressure(long pressure) {
		this.pressure = pressure;
	}
	public long getHumidity() {
		return humidity;
	}
	public void setHumidity(long humidity) {
		this.humidity = humidity;
	}
	public Double getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(Double temp_min) {
		this.temp_min = temp_min;
	}
	public Double getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(Double temp_max) {
		this.temp_max = temp_max;
	}
	@Override
	public String toString() {
		return "Main [temp=" + temp + ", pressure=" + pressure + ", humidity=" + humidity + ", temp_min=" + temp_min
				+ ", temp_max=" + temp_max + "]";
	}
	public Object getSea_level() {
		return sea_level;
	}
	public void setSea_level(Object sea_level) {
		this.sea_level = sea_level;
	}
	public Object getGrnd_level() {
		return grnd_level;
	}
	public void setGrnd_level(Object grnd_level) {
		this.grnd_level = grnd_level;
	}
	
	
	
	

}
