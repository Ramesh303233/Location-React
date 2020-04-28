package com.bharath.location.service;

import java.util.List;

import com.bharath.location.entities.City;

public interface CityService {

	
	List<City>  getAllDetails();

	List<City> getAllDetailsById(String id);
}
