package com.lcwd.hotel.hotelservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.hotel.hotelservice.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,String>{
    
}
