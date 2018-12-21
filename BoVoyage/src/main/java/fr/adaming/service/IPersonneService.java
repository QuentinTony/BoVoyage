package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Personne;

public interface IPersonneService {

	public Personne addPersonne(Personne personne);

	public List<Personne> getAllPersonne();

	public Personne getPersonne(long id);

	public int deletePersonne(Personne personne);

	public int updatePersonne(Personne personne);

}
