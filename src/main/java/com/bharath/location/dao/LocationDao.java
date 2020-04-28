package com.bharath.location.dao;

import java.util.List;

import com.bharath.location.entities.City;
import com.bharath.location.entities.Location;

public interface LocationDao {

	boolean saveQuery(Location location);
	
	List<City> getCityDetails(String id);
}
