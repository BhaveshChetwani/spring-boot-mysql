package com.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.location.entities.WpUser;

public interface WpUserRepo extends JpaRepository<WpUser, Integer> {

}
