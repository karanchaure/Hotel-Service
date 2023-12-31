package com.lcwd.user.service.userservice.enities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Rating {
   
    private String ratingId;
    private String userId;
    private String HotelId;
    private String feedback;
    private int rating;
    private Hotel hotel;
    

}
