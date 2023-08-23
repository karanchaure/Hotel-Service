package com.lcwd.user.service.userservice;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lcwd.user.service.userservice.enities.Rating;
import com.lcwd.user.service.userservice.external.service.RatingService;

@SpringBootTest
class UserserviceApplicationTests {

	@Autowired
	RatingService ratingService;
	private Logger LOG =LoggerFactory.getLogger(UserserviceApplicationTests.class);

	@Test
	void contextLoads() {
	}

	@Test
	void createRating(){
		Rating rating = Rating.builder().userId("kk").HotelId("hh").rating(5).feedback("amazing").build();
		Rating response = ratingService.createRating(rating);
		LOG.info("response : {}", response);

	}
}
