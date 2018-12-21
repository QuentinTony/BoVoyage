package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue(value="client")
public class Client extends Personne implements Serializable{

	//attributs
	@Transient
	private long numeroCarte;
	@Transient
	private Date dateExpiration;
	@Transient
	private int cleSecurite;
	@Transient
	private boolean active;
	
	//transformation de UML en JAVA
	@OneToMany(mappedBy="client")
	private List<Passager> listPassager;
	
	//constructeurs
	public Client() {
		super();
	}
	public Client(String nom, String prenom, Date dn, String mail, String telephone) {
		super(nom, prenom, dn, mail, telephone);
		
	}
	public Client(long id, String nom, String prenom, Date dn, String mail, String telephone) {
		super(id, nom, prenom, dn, mail, telephone);

	}
	
	//getters et setters
	public long getNumeroCarte() {
		return numeroCarte;
	}
	public void setNumeroCarte(long numeroCarte) {
		this.numeroCarte = numeroCarte;
	}
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public int getCleSecurite() {
		return cleSecurite;
	}
	public void setCleSecurite(int cleSecurite) {
		this.cleSecurite = cleSecurite;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	public List<Passager> getListPassager() {
		return listPassager;
	}
	public void setListPassager(List<Passager> listPassager) {
		this.listPassager = listPassager;
	}
	//toString
	@Override
	public String toString() {
		return "Client [numeroCarte=" + numeroCarte + ", dateExpiration=" + dateExpiration + ", cleSecurite="
				+ cleSecurite + ", active=" + active + "]";
	}
	


	
	
}
