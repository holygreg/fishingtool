package persist.dao.interfaces;

import java.util.List;

public interface DaoInterface<T,K> {

	/**
	 * Saves the given entity to the database.
	 * 
	 * @param entity
	 *            entity to persist
	 */
	public void saveOrUpdate(T entity);


	/**
	 * Finds the entity corresponding to the given id.
	 * 
	 * @param id
	 *            Id of the entity to be found.
	 * @return found entity
	 */
	public T findById(K id);

	/**
	 * Deletes the given entity.
	 * 
	 * @param entity entity to be deleted.
	 */
	public void delete(T entity);

	/**
	 * Finds all entities of the respective type.
	 * @return all found entities.
	 */
	public List<T> findAll();

	/**
	 * Deletes all entities of the respective type.
	 */
	public void deleteAll();

}
