package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name="destinations")
public class Destination implements Serializable{

	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String continent;
	private String pays;
	private double longitude;
	private double latitude;
	
	@Lob
	private byte[] photo;
	private String villeArrive;
	
	//transformation de l'association UML en JAVA
	@OneToOne
	@JoinColumn(name="id_vo", referencedColumnName="id")
	private Voyage voyage;
	
	@OneToMany(mappedBy="destination")
	private List<Hotel> hotel;
	
	@OneToMany(mappedBy="destination")
	private List<Prestation> prestation;
	
	@OneToMany(mappedBy="destination")
	private List<Vehicule> vehicule;
	
	//constructeurs
	public Destination() {
		super();
	}
	public Destination(String continent, String pays, double longitude, double latitude, byte[] photo,
			String villeArrive) {
		super();
		this.continent = continent;
		this.pays = pays;
		this.longitude = longitude;
		this.latitude = latitude;
		this.photo = photo;
		this.villeArrive = villeArrive;
	}
	public Destination(long id, String continent, String pays, double longitude, double latitude, byte[] photo,
			String villeArrive) {
		super();
		this.id = id;
		this.continent = continent;
		this.pays = pays;
		this.longitude = longitude;
		this.latitude = latitude;
		this.photo = photo;
		this.villeArrive = villeArrive;
	}
	
	//getters et setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public byte[] getPhoto() {
		return photo;
	}
	
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getVilleArrive() {
		return villeArrive;
	}
	public void setVilleArrive(String villeArrive) {
		this.villeArrive = villeArrive;
	}
	
	
	
	public List<Hotel> getHotel() {
		return hotel;
	}
	public void setHotel(List<Hotel> hotel) {
		this.hotel = hotel;
	}
	public Voyage getVoyage() {
		return voyage;
	}
	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	@Override
	public String toString() {
		return "Destination [id=" + id + ", continent=" + continent + ", pays=" + pays + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", villeArrive=" + villeArrive + "]";
	}
	
	
}
