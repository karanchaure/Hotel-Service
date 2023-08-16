package com.lcwd.rating.ratingservice.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.ratingservice.entities.Rating;
import com.lcwd.rating.ratingservice.repo.RatingRepository;
import com.lcwd.rating.ratingservice.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
    
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        String randomUserID = UUID.randomUUID().toString();
        rating.setRatingId(randomUserID);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
    
}
