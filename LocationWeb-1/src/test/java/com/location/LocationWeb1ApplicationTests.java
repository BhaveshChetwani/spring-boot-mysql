package com.location;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.location.entities.Location;
import com.location.repos.LocationRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationWeb1ApplicationTests {

@Autowired
LocationRepo lr;

@Test
public void saveLocation() {
	Location l = new Location();
	l.setCode("002");
	l.setName("charminar");
	l.setType("tourist");
	
	//lr.save(l);
}
}
