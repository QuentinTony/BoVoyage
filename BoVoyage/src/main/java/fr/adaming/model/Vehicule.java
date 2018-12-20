package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicules")
public class Vehicule implements Serializable{
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String type;
	@Lob
	private byte[] photo;
	private double prix;
	private boolean selection;
	
	//Transformation de l'association UML en JAVA
	@OneToOne
	@JoinColumn(name="id_vo", referencedColumnName="id")
	private Voyage voyage;
	
	//constructeurs
	public Vehicule() {
		super();
	}
	public Vehicule(String type, byte[] photo, double prix, boolean selection) {
		super();
		this.type = type;
		this.photo = photo;
		this.prix = prix;
		this.selection = selection;
	}
	public Vehicule(long id, String type, byte[] photo, double prix, boolean selection) {
		super();
		this.id = id;
		this.type = type;
		this.photo = photo;
		this.prix = prix;
		this.selection = selection;
	}
	
	// getters et setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public boolean isSelection() {
		return selection;
	}
	public void setSelection(boolean selection) {
		this.selection = selection;
	}
	
	
	public Voyage getVoyage() {
		return voyage;
	}
	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	@Override
	public String toString() {
		return "Vehicule [id=" + id + ", type=" + type + ", photo=" + Arrays.toString(photo) + ", prix=" + prix
				+ ", selection=" + selection + "]";
	}
	
	
	

}
