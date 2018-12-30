package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "personnes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role")
@DiscriminatorValue(value = "null")
public class Personne implements Serializable {

	// attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	@NotEmpty(message="le champ ne doit pas être vide")
	protected String nom;
	@NotEmpty(message="le champ ne doit pas être vide")
	protected String prenom;
	@Temporal(TemporalType.DATE)
	@Past
	@NotNull
	protected Date dn;
	@NotEmpty(message="le champ ne doit pas être nul")
	@Email(message="le champ doit contenir un @")
	protected String mail;
	@Min(value = 10, message="le champ doit contenir 10 chiffres")
	protected String telephone;

	// constructeurs
	public Personne() {
		super();
	}

	public Personne(String nom, String prenom, Date dn, String mail, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dn = dn;
		this.mail = mail;
		this.telephone = telephone;
	}

	public Personne(long id, String nom, String prenom, Date dn, String mail, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dn = dn;
		this.mail = mail;
		this.telephone = telephone;
	}

	// getters et setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Date getDn() {
		return dn;
	}

	public void setDn(Date dn) {
		this.dn = dn;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dn=" + dn + ", mail=" + mail
				+ ", telephone=" + telephone + "]";
	}

}
