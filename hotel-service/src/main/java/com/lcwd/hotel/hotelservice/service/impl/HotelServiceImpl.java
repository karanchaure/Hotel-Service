package com.lcwd.hotel.hotelservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.hotelservice.entities.Hotel;
import com.lcwd.hotel.hotelservice.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.hotelservice.repo.HotelRepository;
import com.lcwd.hotel.hotelservice.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel save(Hotel hotel) {
        String randomId= UUID.randomUUID().toString();
        hotel.setId(randomId);
        return hotelRepository.save(hotel);

    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Requested Hotel not found !!! PLEASE TRY AGAIN"));
    }
    
}
