package com.lcwd.rating.ratingservice.service;

import java.util.List;

import com.lcwd.rating.ratingservice.entities.Rating;

public interface RatingService {

    public Rating create(Rating rating);
    public List<Rating> getRatings();
    public List<Rating> getRatingByUserId(String userId);
    public List<Rating> getRatingByHotelId(String hotelId);
    
}
