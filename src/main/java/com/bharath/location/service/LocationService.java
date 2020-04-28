package com.bharath.location.service;

import java.util.List;

import com.bharath.location.entities.Location;

public interface LocationService {

	Location save(Location location);

	void delete(Location location);

	Location update(Location location);

	Location findById(int id);

	List<Location> findALl();

}
