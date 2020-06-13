package com.bharath.location.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bharath.location.entities.Location;
import com.bharath.location.repos.LocationRepository;
import com.bharath.location.service.LocationService;
import com.bharath.location.util.EmailUtil;
import com.bharath.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService service;

	@Autowired(required = true)
	EmailUtil emailUtil;

	@Autowired
	LocationRepository repository;

	@Autowired
	ReportUtil reportUtil;

	@Autowired
	ServletContext sc;

	@RequestMapping("/showCreate")
	public String showCreate() {
	
		return "createLocation";

	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {

		Location locationSer = service.save(location);
		String msg = "Location is saved with" + locationSer.getId();
	//	emailUtil.sendEmail("chouhanramesh74@gmail.com", "Location check mail date 29-04-2019",
			//	"This is test mail for location application");
		modelMap.addAttribute("msg", msg);
		return "createLocation";
	}

	@GetMapping("/displayLocations")
	public String displayAll(ModelMap modelMap) {

		List<Location> locations = service.findALl();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLoc(@RequestParam("id") int id, ModelMap modelMap) {

		Location location = service.findById(id);

		// option to get details
		// Location location = new Location();
		// location.setId(id);
		service.delete(location);

		List<Location> locations = service.findALl();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";

	}

	@RequestMapping("/editLocation")
	public String editLoc(@RequestParam("id") int id, ModelMap modelMap) {

		Location location = service.findById(id);
		modelMap.addAttribute("location", location);
		return "editLocations";

	}

	@RequestMapping("/updateLoc")
	public String updateLoc(@ModelAttribute("location") Location location, ModelMap modelMap) {
		service.update(location);
		List<Location> locations = service.findALl();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";

	}

	@RequestMapping("/report")
	public String showReport() {

		String path = sc.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);

		return "report";
	}

}
