package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "voyages")
public class Voyage implements Serializable {

	// declaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date dateDepart;
	@Temporal(TemporalType.DATE)
	private Date dateRetour;
	private double prix;
	private double remise;
	private String villeDepart;
	private int nombrePersonne;
	private int stockPassager;

	// transformation de l'association UML en JAVA
	@OneToOne
	private Destination destination;
	@OneToOne
	private Hotel hotel;
	@ManyToMany
	@JoinTable(name = "pas_voy", joinColumns = @JoinColumn(name = "pa_id"), inverseJoinColumns = @JoinColumn(name = "vo_id"))
	private List<Passager> listPassager;
	@OneToOne
	private Vehicule vehicule;
	@OneToMany(mappedBy = "voyage")
	private List<Prestation> listPrestation;
	@OneToOne
	private Assurance assurance;

	// declaration des constructeurs
	public Voyage() {
		super();
	}

	public Voyage(Date dateDepart, Date dateRetour, double prix, double remise, String villeDepart, int nombrePersonne,
			int stockPassager) {
		super();
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.prix = prix;
		this.remise = remise;
		this.villeDepart = villeDepart;
		this.nombrePersonne = nombrePersonne;
		this.stockPassager = stockPassager;
	}

	public Voyage(long id, Date dateDepart, Date dateRetour, double prix, double remise, String villeDepart,
			int nombrePersonne, int stockPassager) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.prix = prix;
		this.remise = remise;
		this.villeDepart = villeDepart;
		this.nombrePersonne = nombrePersonne;
		this.stockPassager = stockPassager;
	}

	// getters et setters

	public long getId() {
		return id;
	}

	public int getStockPassager() {
		return stockPassager;
	}

	public void setStockPassager(int stockPassager) {
		this.stockPassager = stockPassager;
	}

	public List<Passager> getListPassager() {
		return listPassager;
	}

	public void setListPassager(List<Passager> listPassager) {
		this.listPassager = listPassager;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getRemise() {
		return remise;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public int getNombrePersonne() {
		return nombrePersonne;
	}

	public void setNombrePersonne(int nombrePersonne) {
		this.nombrePersonne = nombrePersonne;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public List<Prestation> getListPrestation() {
		return listPrestation;
	}

	public void setListPrestation(List<Prestation> listPrestation) {
		this.listPrestation = listPrestation;
	}

	public Assurance getAssurance() {
		return assurance;
	}

	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}

	@Override
	public String toString() {
		return "Voyage [id=" + id + ", dateDepart=" + dateDepart + ", dateRetour=" + dateRetour + ", prix=" + prix
				+ ", remise=" + remise + ", villeDepart=" + villeDepart + ", nombrePersonne=" + nombrePersonne
				+ ", stockPassager=" + stockPassager + "]";
	}

}
