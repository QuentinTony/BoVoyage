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
@Table(name = "vehicules")
public class Vehicule implements Serializable {

	// declaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String type;
	@Lob
	private byte[] photo;
	private double prix;
	private boolean selection;

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	// Transformation de l'association UML en JAVA
	@ManyToOne
	@JoinColumn(name="id_de", referencedColumnName="id")
	private Destination destination;

	@OneToMany(mappedBy = "vehicule")
	private List<Formule> listFormule;

	public List<Formule> getListFormule() {
		return listFormule;
	}

	public void setListFormule(List<Formule> listFormule) {
		this.listFormule = listFormule;
	}

	// constructeurs
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

	@Override
	public String toString() {
		return "Vehicule [id=" + id + ", type=" + type + ", photo=" + Arrays.toString(photo) + ", prix=" + prix
				+ ", selection=" + selection + "]";
	}

}
