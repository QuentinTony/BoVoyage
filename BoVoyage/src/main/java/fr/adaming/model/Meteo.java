package fr.adaming.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@XmlRootElement
public class Meteo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private int cod;
	private Main main;
	@JsonIgnore
	private Object coord;
	@JsonIgnore
	private Weather weather;
	
	private Wind wind;
	
	private Object clouds;
	private long dt;
	@JsonIgnore
	private Object sys;
	
	@JsonIgnore
	private Object rain;
	
	private String base;
	
	private long visibility;
	
	
	

	

	public Meteo(long id, String name, int cod, Main main, Object coord, Weather weather, Wind wind, Object clouds,
			long dt, Object sys, Object rain, String base, long visibility) {
		super();
		this.id = id;
		this.name = name;
		this.cod = cod;
		this.main = main;
		this.coord = coord;
		this.weather = weather;
		this.wind = wind;
		this.clouds = clouds;
		this.dt = dt;
		this.sys = sys;
		this.rain = rain;
		this.base = base;
		this.visibility = visibility;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Meteo() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@Override
	public String toString() {
		return "Meteo [id=" + id + ", name=" + name + ", cod=" + cod + ", main=" + main + "]";
	}

	public Object getCoord() {
		return coord;
	}

	public void setCoord(Object coord) {
		this.coord = coord;
	}



	public Object getClouds() {
		return clouds;
	}

	public void setClouds(Object clouds) {
		this.clouds = clouds;
	}

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public Object getSys() {
		return sys;
	}

	public void setSys(Object sys) {
		this.sys = sys;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public long getVisibility() {
		return visibility;
	}

	public void setVisibility(long visibility) {
		this.visibility = visibility;
	}

	public Object getRain() {
		return rain;
	}

	public void setRain(Object rain) {
		this.rain = rain;
	}
	
	

}
