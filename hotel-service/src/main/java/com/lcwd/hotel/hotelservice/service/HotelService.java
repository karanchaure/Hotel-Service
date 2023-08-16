package com.lcwd.hotel.hotelservice.service;

import java.util.List;

import com.lcwd.hotel.hotelservice.entities.Hotel;

public interface HotelService {
    
    public Hotel save(Hotel hotel);

    public List<Hotel> getAll();

    public Hotel getHotel(String id);
    
}
