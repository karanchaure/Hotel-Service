package com.lcwd.rating.ratingservice.service;

import java.util.List;

import com.lcwd.rating.ratingservice.entities.Rating;

public interface RatingService {

    public Rating create(Rating rating);
    public List<Rating> getRatings();
    public Rating getRatingByUserId(String id);
    public Rating getRatingByHotelId(String id);
    
}
