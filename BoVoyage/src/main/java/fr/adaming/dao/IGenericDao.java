package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {

	public void setGeneric(Class<T> generic);

	public T add(final T newInstance);

	public T getById(final long id);

	public List<T> getAll();

	public int update(final T transientObject);

	public void delete(final T persistentObject);
}
