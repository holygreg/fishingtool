package persist.dao.impl;

import java.util.List;

import persist.dao.interfaces.HookDaoInterface;
import persist.entities.Hook;
import persist.entities.HookKey;

public class HookDaoImpl extends AbstractDaoImpl<Hook,HookKey> implements HookDaoInterface {

	@Override
	public Hook findById(HookKey id) {
		openCurrentSessionwithTransaction();
		Hook hook = (Hook) getCurrentSession().get(Hook.class, id);
		closeCurrentSessionwithTransaction();
		return hook;
	}

	@Override
	public List<Hook> findAll() {
		openCurrentSessionwithTransaction();
		@SuppressWarnings("unchecked")
		List<Hook> hooks = (List<Hook>) getCurrentSession().createQuery("from Hook").list();
		closeCurrentSessionwithTransaction();
		return hooks;
	}

}
