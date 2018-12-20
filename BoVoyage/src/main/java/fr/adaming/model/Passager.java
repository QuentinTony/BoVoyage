package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@DiscriminatorValue(value="passager")
public class Passager extends Personne implements Serializable{

	//attributs
	private long numero;
	
	// transformation de l'association UML en JAVA
	@ManyToMany(mappedBy="listPassager")
	private List<Voyage> listVoyage;
	
	@ManyToOne
	@JoinColumn(name="id_cl", referencedColumnName="id")
	private Client client;

	//constructeurs
	public Passager() {
		super();
	}

	public Passager(String nom, String prenom, Date dn, String mail, String telephone, long numero) {
		super(nom, prenom, dn, mail, telephone);
		this.numero = numero;
	}

	public Passager(long id, String nom, String prenom, Date dn, String mail, String telephone, long numero) {
		super(id, nom, prenom, dn, mail, telephone);
		this.numero = numero;
	}

	//getters et setters
	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}
	
	

	public List<Voyage> getListVoyage() {
		return listVoyage;
	}

	public void setListVoyage(List<Voyage> listVoyage) {
		this.listVoyage = listVoyage;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Passager [numero=" + numero + "]";
	}
	
	
}
