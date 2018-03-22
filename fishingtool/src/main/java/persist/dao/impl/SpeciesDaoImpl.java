package persist.dao.impl;

import java.util.List;

import persist.dao.interfaces.SpeciesDaoInterface;
import persist.entities.Species;

public class SpeciesDaoImpl extends AbstractDaoImpl<Species> implements SpeciesDaoInterface {

	@Override
	public Species findById(int id) {
		Species species = (Species) getCurrentSession().get(Species.class, id);
		return species;
	}

	@Override
	public List<Species> findAll() {
		@SuppressWarnings("unchecked")
		List<Species> species = (List<Species>) getCurrentSession().createQuery("from Species").list();
		return species;
	}

}
