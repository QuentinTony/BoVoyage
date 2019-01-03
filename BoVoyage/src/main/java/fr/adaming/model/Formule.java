package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "formules")
public class Formule implements Serializable {

	// ******************declaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double prixFinal;
	// nombre de personnes qui partiront dans cette formule pour un client
	private int nombrePersonne;
	private int nombreNuit;
	private int nombreJour;
	private int compteur;
	// pls prest par formule et pls formule pvt avoir les memes prest
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "form_presta", joinColumns = @JoinColumn(name = "pr_id"), inverseJoinColumns = @JoinColumn(name = "fo_id"))
	private List<Prestation> listPrestation;

	@ManyToOne
	@JoinColumn(name = "id_cl", referencedColumnName = "id")
	private Client client;

	// 1 hotel par formule mais pls formule pvt avoir le meme hotel
	@ManyToOne
	@JoinColumn(name = "id_vo", referencedColumnName = "id")
	private Voyage voyage;
	// 1 hotel par formule mais pls formule pvt avoir le meme hotel
	@ManyToOne
	@JoinColumn(name = "id_ho", referencedColumnName = "id")
	private Hotel hotel;
	// 1 vehicule par formule mais pls formule pvt avoir le meme vehicule
	@ManyToOne
	@JoinColumn(name = "id_ve", referencedColumnName = "id")
	private Vehicule vehicule;
	// 1 assurance par formule mais pls formule pvt avoir la meme assurance
	@ManyToOne
	@JoinColumn(name = "id_as", referencedColumnName = "id")
	private Assurance assurance;

	public Client getClient() {
		return client;
	}

	public Formule(long id, double prixFinal, int nombrePersonne, int nombreNuit, int nombreJour,
			List<Prestation> listPrestation, Client client, Voyage voyage, Hotel hotel, Vehicule vehicule,
			Assurance assurance) {
		super();
		this.id = id;
		this.prixFinal = prixFinal;
		this.nombrePersonne = nombrePersonne;
		this.nombreNuit = nombreNuit;
		this.nombreJour = nombreJour;
		this.listPrestation = listPrestation;
		this.client = client;
		this.voyage = voyage;
		this.hotel = hotel;
		this.vehicule = vehicule;
		this.assurance = assurance;
	}

	public int getCompteur() {
		return compteur;
	}


	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}


	public int getNombreNuit() {
		return nombreNuit;
	}

	public void setNombreNuit(int nombreNuit) {
		this.nombreNuit = nombreNuit;
	}

	public int getNombreJour() {
		return nombreJour;
	}

	public void setNombreJour(int nombreJour) {
		this.nombreJour = nombreJour;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
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

	public Assurance getAssurance() {
		return assurance;
	}

	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}

	// ******************constructeurs
	public Formule() {
		super();
	}

	
	// ******************getter setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrixFinal() {
		return prixFinal;
	}

	public void setPrixFinal(double prixFinal) {
		this.prixFinal = prixFinal;
	}

	public int getNombrePersonne() {
		return nombrePersonne;
	}

	public void setNombrePersonne(int nombrePersonne) {
		this.nombrePersonne = nombrePersonne;
	}

	public List<Prestation> getListPrestation() {
		return listPrestation;
	}

	public void setListPrestation(List<Prestation> listPrestation) {
		this.listPrestation = listPrestation;
	}

	public Formule(double prixFinal, int nombrePersonne, int nombreNuit, int nombreJour,
			List<Prestation> listPrestation, Client client, Voyage voyage, Hotel hotel, Vehicule vehicule,
			Assurance assurance) {
		super();
		this.prixFinal = prixFinal;
		this.nombrePersonne = nombrePersonne;
		this.nombreNuit = nombreNuit;
		this.nombreJour = nombreJour;
		this.listPrestation = listPrestation;
		this.client = client;
		this.voyage = voyage;
		this.hotel = hotel;
		this.vehicule = vehicule;
		this.assurance = assurance;
	}

	// ******************to string

	@Override
	public String toString() {
		return "Formule [id=" + id + ", prixFinal=" + prixFinal + ", nombrePersonne=" + nombrePersonne + "]";
	}

}
