package com.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.location.entities.Location;
import com.location.repos.LocationRepo;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

	@Autowired
	LocationRepo locationRepo;
	
	@GetMapping
	public List<Location> getLocations(){
		
		return locationRepo.findAll();
	}
	
	@PostMapping
	public void createLocation(@RequestBody Location location) {
		locationRepo.save(location);
	} 
	
	@PutMapping
	public void updateLocation(@RequestBody Location location) {
		locationRepo.save(location);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		locationRepo.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Location getLocation(@PathVariable("id") int id) {
		return locationRepo.findById(id).get();
	}
}
