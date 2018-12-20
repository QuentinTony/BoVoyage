package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

public class GenericDaoImpl<T extends Serializable> implements IGenericDao<T> {

	@Autowired
	private EntityManagerFactory emf;

	private Class<T> generic;

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void setGeneric(Class<T> generic) {
		this.generic = generic;

	}

	@Override
	public T add(T o) {
		EntityManager em = emf.createEntityManager();
		em.persist(o);
		return (T) o;
	}

	@Override
	public T getById(long id) {
		EntityManager em = emf.createEntityManager();
		T o = (T) em.find(generic, id);
		return (T) o;
	}

	@Override
	public List<T> getAll() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("FROM " + generic.getName()).getResultList();
	}

	@Override
	public int update(T o) {
		EntityManager em = emf.createEntityManager();
		if (em.merge(o) != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public void delete(T o) {
		EntityManager em = emf.createEntityManager();
		em.remove(o);
	}

}
