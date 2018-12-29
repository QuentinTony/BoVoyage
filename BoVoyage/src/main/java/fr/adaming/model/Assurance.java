package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy="assurance")
	private List<Formule> listFormule;
	
	public List<Formule> getListFormule() {
		return listFormule;
	}
	public void setListFormule(List<Formule> listFormule) {
		this.listFormule = listFormule;
	}
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
	
	

	@Override
	public String toString() {
		return "Assurance [id=" + id + ", type=" + type + ", selection=" + selection + ", prix=" + prix + "]";
	}
	
	

}
