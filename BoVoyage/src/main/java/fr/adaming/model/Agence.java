package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="agences")
public class Agence implements Serializable{
	
	//Declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nom ;
	private String prenom;
	private String mail;
	private String mdp;
	private String statut;
	private boolean active;
	
	// constructeurs
	public Agence() {
		super();
	}

	
	
	
	
	
	
	
	public Agence(String nom, String prenom, String mail, String mdp, String statut, boolean active) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.statut = statut;
		this.active = active;
	}








	public Agence(long id, String nom, String prenom, String mail, String mdp, String statut, boolean active) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.statut = statut;
		this.active = active;
	}








	//getters et setters
	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}






	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	
	public boolean isActive() {
		return active;
	}








	public void setActive(boolean active) {
		this.active = active;
	}








	@Override
	public String toString() {
		return "Agence [id=" + id + ", mail=" + mail + ", mdp=" + mdp + ", statut=" + statut + "]";
	}

	
}
