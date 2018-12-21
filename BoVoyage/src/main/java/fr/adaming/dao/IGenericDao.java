package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {

	public void setGeneric(Class<T> generic);

	public T add(final T newInstance);

	public T getById(long id);

	public List<T> getAll();

	public int update(T transientObject);

	public void delete(T persistentObject);
}
