package com.location.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.location.entities.Location;
import com.location.entities.WpUser;
import com.location.repos.LocationRepo;
import com.location.service.LocationService;
import com.location.service.WpUserService;
import com.location.util.EmailUtil;
import com.location.util.Helper;
import com.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService ls;

	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	LocationRepo repo;
	
	@Autowired
	WpUserService wpService;

	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext sc;
	
	@RequestMapping("/showCreate")
	public String showCreate(@RequestParam(value = "id", required = false) String id, ModelMap modelMap) {
		if (id != null) {
			Optional<Location> locations = ls.getLocationById(Integer.parseInt(id));
			Location location = locations.get();
			if (location != null)
				modelMap.addAttribute("location", location);
		} else {
			modelMap.addAttribute("location", null);
		}
		return "createLocation";
	}

	@RequestMapping("/saveLocation")
	public String createLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = ls.saveLocation(location);
		String msg = "Location saved with id: " + locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("morampudi.himabindhu@gmail.com", Helper.postName, Helper.emailBody);
		// emailUtil.sendEmail(toAddress, "test app", "Hi Babe");
		return "createLocation";
	}

	@RequestMapping("/displayAll")
	public String displayAll(ModelMap modelMap) {
		List<Location> locations = ls.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "showAllLocation";
	}

	@RequestMapping("/deleteLocation")
	public String displayAll(@RequestParam("id") int id, ModelMap modelMap) {
		Optional<Location> location = ls.getLocationById(id);
		ls.deleteLocation(location.get());
		List<Location> locations = ls.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "showAllLocation";
	}
	
	@RequestMapping("/report")
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> data = repo.findTypeAndTypeCount();
		reportUtil.generateChart(path, data);
		return "report";
	}
}
