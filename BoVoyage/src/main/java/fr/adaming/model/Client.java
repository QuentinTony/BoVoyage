package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue(value = "client")
public class Client extends Personne implements Serializable {

	// attributs

	@Length(min = 8, max= 20,message="le mot de passe doit contenir 8 caractères")
	protected String mdp;
	@Transient
	private long numeroCarte;
	@Transient
	private Date dateExpiration;
	@Transient
	private int cleSecurite;
	@Transient
	private boolean active;

	public List<Formule> getListFormule() {
		return listFormule;
	}

	public void setListFormule(List<Formule> listFormule) {
		this.listFormule = listFormule;
	}

	// transformation de UML en JAVA
	@OneToMany(mappedBy = "client")
	private List<Passager> listPassager;

	@OneToMany(mappedBy = "client")
	private List<Formule> listFormule;

	// constructeurs
	public Client() {
		super();
	}

	public Client(String nom, String prenom, Date dn, String mail, String telephone) {
		super(nom, prenom, dn, mail, telephone);

	}

	public Client(long id, String nom, String prenom, Date dn, String mail, String telephone) {
		super(id, nom, prenom, dn, mail, telephone);

	}

	// getters et setters
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

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<Passager> getListPassager() {
		return listPassager;
	}

	public void setListPassager(List<Passager> listPassager) {
		this.listPassager = listPassager;
	}

	// toString
	@Override
	public String toString() {
		return "Client [numeroCarte=" + numeroCarte + ", dateExpiration=" + dateExpiration + ", cleSecurite="
				+ cleSecurite + ", active=" + active + "]";
	}

}
