package persist.dao.impl;

import java.util.List;

import persist.dao.interfaces.CatchDaoInterface;
import persist.entities.Catch;

public class CatchDaoImpl extends AbstractDaoImpl<Catch,Integer> implements CatchDaoInterface {

	@Override
	public Catch findById(Integer id) {
		openCurrentSessionwithTransaction();
		Catch catch_ = (Catch) getCurrentSession().get(Catch.class, id);
		closeCurrentSessionwithTransaction();
		return catch_;
	}

	@Override
	public List<Catch> findAll() {
		openCurrentSessionwithTransaction();
		@SuppressWarnings("unchecked")
		List<Catch> catchs = (List<Catch>) getCurrentSession().createQuery("from Catch").list();
		closeCurrentSessionwithTransaction();
		return catchs;
	}

}
