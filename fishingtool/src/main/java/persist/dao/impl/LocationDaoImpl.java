package persist.dao.impl;

import java.util.List;

import persist.dao.interfaces.LocationDaoInterface;
import persist.entities.Location;

public class LocationDaoImpl extends AbstractDaoImpl<Location,Integer> implements LocationDaoInterface {

	@Override
	public Location findById(Integer id) {
		openCurrentSessionwithTransaction();
		Location location = (Location) getCurrentSession().get(Location.class, id);
		closeCurrentSessionwithTransaction();
		return location;
	}

	@Override
	public List<Location> findAll() {
		openCurrentSessionwithTransaction();
		@SuppressWarnings("unchecked")
		List<Location> locations = (List<Location>) getCurrentSession().createQuery("from Location").list();
		closeCurrentSessionwithTransaction();
		return locations;
	}

}
