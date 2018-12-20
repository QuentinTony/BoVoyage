package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="assurances")
public class Assurance implements Serializable{
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String type;
	private boolean selection;
	private double prix;
	
	//transformation de l'association UML en JAVA
	@OneToOne
	@JoinColumn(name="id_vo", referencedColumnName="id")
	private Voyage voyage;
	
	//constructeurs
	public Assurance() {
		super();
	}
	public Assurance(String type, boolean selection, double prix) {
		super();
		this.type = type;
		this.selection = selection;
		this.prix = prix;
	}
	public Assurance(long id, String type, boolean selection, double prix) {
		super();
		this.id = id;
		this.type = type;
		this.selection = selection;
		this.prix = prix;
	}
	
	//getters et setters
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
	public boolean isSelection() {
		return selection;
	}
	public void setSelection(boolean selection) {
		this.selection = selection;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	public Voyage getVoyage() {
		return voyage;
	}
	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	@Override
	public String toString() {
		return "Assurance [id=" + id + ", type=" + type + ", selection=" + selection + ", prix=" + prix + "]";
	}
	
	

}
