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
	private String mail;
	private String mdp;
	private String statut;
	
	// constructeurs
	public Agence() {
		super();
	}
	public Agence(String mail, String mdp, String statut) {
		super();
		this.mail = mail;
		this.mdp = mdp;
		this.statut = statut;
	}
	public Agence(long id, String mail, String mdp, String statut) {
		super();
		this.id = id;
		this.mail = mail;
		this.mdp = mdp;
		this.statut = statut;
	}
	
	//getters et setters
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
	@Override
	public String toString() {
		return "Agence [id=" + id + ", mail=" + mail + ", mdp=" + mdp + ", statut=" + statut + "]";
	}

	
}
