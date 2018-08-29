package com.location.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.entities.Location;
import com.location.repos.LocationRepo;

@Service
public class LocationServImpl implements LocationService {

	@Autowired
	private LocationRepo lr;

	@Override
	public Location saveLocation(Location location) {
		return lr.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return lr.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		lr.delete(location);
	}

	@Override
	public Optional<Location> getLocationById(int id) {
		return lr.findById(id);
	}

	@Override
	public List<Location> getAllLocation() {
		return lr.findAll();
	}

}
