package com.bharath.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharath.location.dao.LocationDao;
import com.bharath.location.entities.City;
import com.bharath.location.entities.Location;
import com.bharath.location.repos.CityRepository;

@Service
public class CityServiceImpl implements CityService{

	
	@Autowired
	LocationDao locDao;
	
	@Autowired
	CityRepository cityRepository;
	
	@Override
	public List<City> getAllDetails() {
	
		Location l = new Location();
		locDao.saveQuery(l);
		return cityRepository.findAll();
	}

	@Override
	public List<City> getAllDetailsById(String id) {
	
		return locDao.getCityDetails(id);
	}

}
