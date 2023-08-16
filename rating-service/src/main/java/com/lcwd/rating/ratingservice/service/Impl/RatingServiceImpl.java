package com.lcwd.rating.ratingservice.service.Impl;

import java.util.List;
import java.util.UUID;

import com.lcwd.rating.ratingservice.entities.Rating;
import com.lcwd.rating.ratingservice.exception.ResourceNotFoundException;
import com.lcwd.rating.ratingservice.repo.RatingRepository;
import com.lcwd.rating.ratingservice.service.RatingService;

public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        String randomUserID = UUID.randomUUID().toString();
        rating.setUserId(randomUserID);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingByUserId(String id) {
        return (Rating) ratingRepository.findByUserId(id);
    }

    @Override
    public Rating getRatingByHotelId(String id) {
        return (Rating) ratingRepository.findByHotelId(id);
    }
    
}
