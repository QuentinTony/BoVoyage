package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="prestations")
public class Prestation implements Serializable{
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String type;
	private boolean selection;
	private String description;
	@Lob
	private byte[] photo;
	private double prix;
	
	//transformation de l'association UML en JAVA
	@ManyToOne
	@JoinColumn(name="id_de", referencedColumnName="id")
	private Destination destination;
		
	@ManyToMany(mappedBy="listPrestation")
	private List<Formule> listFormule;

	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public List<Formule> getListFormule() {
		return listFormule;
	}
	public void setListFormule(List<Formule> listFormule) {
		this.listFormule = listFormule;
	}
	
	
	//constructeurs
	public Prestation() {
		super();
	}
	public Prestation(String type, boolean selection, String description, byte[] photo, double prix) {
		super();
		this.type = type;
		this.selection = selection;
		this.description = description;
		this.photo = photo;
		this.prix = prix;
	}
	public Prestation(long id, String type, boolean selection, String description, byte[] photo, double prix) {
		super();
		this.id = id;
		this.type = type;
		this.selection = selection;
		this.description = description;
		this.photo = photo;
		this.prix = prix;
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
	public boolean isSelection() {
		return selection;
	}
	public void setSelection(boolean selection) {
		this.selection = selection;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	

	@Override
	public String toString() {
		return "Prestation [id=" + id + ", type=" + type + ", selection=" + selection + ", description=" + description
				+ ", photo=" + Arrays.toString(photo) + ", prix=" + prix + "]";
	}
	
	

}
