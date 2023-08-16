package com.lcwd.rating.ratingservice.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("user_ratings")
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String HotelId;
    private String feedback;
    private int rating;
    

}
