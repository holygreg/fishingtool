package persist.dao.impl;

import java.util.List;

import persist.dao.interfaces.CatchDaoInterface;
import persist.entities.Catch;

public class CatchDaoImpl extends AbstractDaoImpl<Catch> implements CatchDaoInterface {

	@Override
	public Catch findById(int id) {
		Catch catch_ = (Catch) getCurrentSession().get(Catch.class, id);
		return catch_;
	}

	@Override
	public List<Catch> findAll() {
		@SuppressWarnings("unchecked")
		List<Catch> catchs = (List<Catch>) getCurrentSession().createQuery("from Catch").list();
		return catchs;
	}

}
