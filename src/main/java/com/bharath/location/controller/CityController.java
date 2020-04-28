package com.bharath.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.location.entities.City;
import com.bharath.location.service.CityService;

@RestController
public class CityController {

	@Autowired
	CityService cityService;

	@SuppressWarnings("static-access")
	@GetMapping("/AllDetails")
	ResponseEntity<List<City>> getCityAlldetails() {
		List<City> result = null;
			HttpHeaders headers = new HttpHeaders();
		    headers.add("Custom-Header", "foo");
			result = cityService.getAllDetails();	
	return ResponseEntity.status(HttpStatus.OK).body(result);
	
	}
	
	

	@GetMapping("/detailsId")
	ResponseEntity<List<City>> getCitydetailsById(@RequestParam("id") String id) {
		List<City> result = null;
			HttpHeaders headers = new HttpHeaders();
		    headers.add("Custom-Header", "foo");
			result = cityService.getAllDetailsById(id);	
	return ResponseEntity.status(HttpStatus.OK).body(result);
	
	}
	
}
