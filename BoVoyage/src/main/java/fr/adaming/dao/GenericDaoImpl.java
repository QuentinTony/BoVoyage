package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class GenericDaoImpl<T extends Serializable> implements IGenericDao<T> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> generic;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void setGeneric(Class<T> generic) {
		this.generic = generic;

	}

	@Override
	public T add(T o) {
		em.persist(o);
		return (T) o;
	}

	@Override
	public T getById(long id) {
		T o = (T) em.find(generic, id);
		return (T) o;
	}

	@Override
	public List<T> getAll() {
		System.out.println("DAO" + em.createQuery("FROM " + generic.getName()).getResultList());
		return em.createQuery("FROM " + generic.getName()).getResultList();
	}

	@Override
	public int update(T o) {
		if (em.merge(o) != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public void delete(T o) {
		em.remove(em.contains(o) ? o : em.merge(o));
	
	}

}
