package com.bharath.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharath.location.dao.LocationDao;
import com.bharath.location.entities.Location;
import com.bharath.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository repository;

	@Override
	public Location save(Location location) {

		return repository.save(location);
	}

	@Autowired
	LocationDao locDao;

	@Override
	public void delete(Location location) {
		repository.delete(location);

	}

	@Override
	public Location update(Location location) {

		return repository.save(location);
	}

	@Override
	public Location findById(int id) {

		return repository.findById(id).get();
	}

	// getter and setter
	@Override
	public List<Location> findALl() {
		Location l = new Location();
		locDao.saveQuery(l);
		return repository.findAll();
	}

	public LocationRepository getRepository() {
		return repository;
	}

	public void setRepository(LocationRepository repository) {
		this.repository = repository;
	}

}
