package persist.dao.impl;

import java.util.List;

import persist.dao.interfaces.BaitDaoInterface;
import persist.entities.Bait;

public class BaitDaoImpl extends AbstractDaoImpl<Bait,String> implements BaitDaoInterface {

	@Override
	public Bait findById(String id) {
		openCurrentSessionwithTransaction();
		Bait bait = (Bait) getCurrentSession().get(Bait.class, id);
		closeCurrentSessionwithTransaction();
		return bait;

	}

	@Override
	public List<Bait> findAll() {
		openCurrentSessionwithTransaction();
		@SuppressWarnings("unchecked")
		List<Bait> baits = (List<Bait>) getCurrentSession().createQuery("from Bait").list();
		closeCurrentSessionwithTransaction();
		return baits;

	}

}
