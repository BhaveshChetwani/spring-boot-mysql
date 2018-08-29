package com.location.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.entities.WpUser;
import com.location.repos.WpUserRepo;

@Service
public class WpUserServiceImpl implements WpUserService{


	@Autowired
	private WpUserRepo wpRepo;

	@Override
	public WpUser saveLocation(WpUser location) {
		return wpRepo.save(location);
	}

	@Override
	public WpUser updateLocation(WpUser location) {
		return wpRepo.save(location);
	}

	@Override
	public void deleteLocation(WpUser location) {
		wpRepo.delete(location);
	}

	@Override
	public Optional<WpUser> getLocationById(int id) {
		return wpRepo.findById(id);
	}

	@Override
	public List<WpUser> getAllLocation() {
		return wpRepo.findAll();
	}





}
