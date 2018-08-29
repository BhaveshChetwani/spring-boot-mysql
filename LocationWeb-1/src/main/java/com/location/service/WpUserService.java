package com.location.service;

import java.util.List;
import java.util.Optional;

import com.location.entities.WpUser;

public interface WpUserService {

	WpUser saveLocation(WpUser location);

	WpUser updateLocation(WpUser location);

	void deleteLocation(WpUser location);

	Optional<WpUser> getLocationById(int id);

	List<WpUser> getAllLocation();
}
