package persist.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import persist.dao.interfaces.DaoInterface;

public abstract class AbstractDaoImpl<T> implements DaoInterface<T> {

	private Session currentSession;

	private Transaction currentTransaction;

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	@Override
	public void persist(T entity) {
		openCurrentSessionwithTransaction();
		getCurrentSession().save(entity);
		closeCurrentSessionwithTransaction();
	}

	@Override
	public void update(T entity) {
		openCurrentSessionwithTransaction();
		getCurrentSession().update(entity);
		closeCurrentSessionwithTransaction();
	}

	@Override
	public abstract T findById(int id);

	@Override
	public void delete(T entity) {
		openCurrentSessionwithTransaction();
		getCurrentSession().delete(entity);
		closeCurrentSessionwithTransaction();
	}

	@Override
	public abstract List<T> findAll();

	@Override
	public void deleteAll() {
		openCurrentSessionwithTransaction();
		List<T> entityList = findAll();
		for (T entity : entityList) {
			getCurrentSession().delete(entity);
		}
		closeCurrentSessionwithTransaction();
	}

}
