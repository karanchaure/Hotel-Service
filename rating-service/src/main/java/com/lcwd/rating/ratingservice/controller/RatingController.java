package com.lcwd.rating.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.ratingservice.entities.Rating;
import com.lcwd.rating.ratingservice.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }
    
    @GetMapping("users/{userId}")
    public ResponseEntity<Rating> getRatingByUserId(@PathVariable String userId){
        Rating rating = ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(rating);
    }

    @GetMapping("hotels/{hotelId}")
    public ResponseEntity<Rating> getRatingByHotelId(@PathVariable String hotelId){
        Rating rating = ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.ok(rating);
    }

    @GetMapping()
    public ResponseEntity<List<Rating>> getRatings(){
        List<Rating> ratingList = ratingService.getRatings();
        return ResponseEntity.ok(ratingList);
    }
    
}
