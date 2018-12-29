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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="hotels")
public class Hotel implements Serializable{
	
	//Declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String type;
	private String hebergement;
	private int categorie;
	private boolean selection;
	@Lob
	private byte[] photo;
	private double prix;
	private String description;
	
	//Transformation de l'association UML en JAVA
	@ManyToOne
	@JoinColumn(name="id_de", referencedColumnName="id")
	private Destination destination;
	

	@OneToMany(mappedBy="hotel")
	private List<Formule> listFormule;
	
	public List<Formule> getListFormule() {
		return listFormule;
	}
	public void setListFormule(List<Formule> listFormule) {
		this.listFormule = listFormule;
	}
	// constructeurs
	public Hotel() {
		super();
	}
	public Hotel(String type, String hebergement, boolean selection, byte[] photo, double prix, String description) {
		super();
		this.type = type;
		this.hebergement = hebergement;
		this.selection = selection;
		this.photo = photo;
		this.prix = prix;
		this.description = description;
	}
	public Hotel(long id, String type, String hebergement, boolean selection, byte[] photo, double prix,
			String description) {
		super();
		this.id = id;
		this.type = type;
		this.hebergement = hebergement;
		this.selection = selection;
		this.photo = photo;
		this.prix = prix;
		this.description = description;
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
	public int getCategorie() {
		return categorie;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	public String getHebergement() {
		return hebergement;
	}
	public void setHebergement(String hebergement) {
		this.hebergement = hebergement;
	}
	public boolean isSelection() {
		return selection;
	}
	public void setSelection(boolean selection) {
		this.selection = selection;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", type=" + type + ", hebergement=" + hebergement + ", selection=" + selection
				+ ", photo=" + Arrays.toString(photo) + ", prix=" + prix + ", description=" + description + "]";
	}
	
	

}
