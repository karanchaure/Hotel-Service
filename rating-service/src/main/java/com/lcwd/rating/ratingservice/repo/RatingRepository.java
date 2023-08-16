package com.lcwd.rating.ratingservice.repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lcwd.rating.ratingservice.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating,String>{
    
    public List<Rating> findByUserId(String userId);
    
    public List<Rating> findByHotelId(String hotelId);

}
