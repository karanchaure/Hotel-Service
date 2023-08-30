package com.lcwd.user.service.userservice.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.userservice.enities.Hotel;
import com.lcwd.user.service.userservice.enities.Rating;
import com.lcwd.user.service.userservice.enities.User;
import com.lcwd.user.service.userservice.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.userservice.external.service.HotelService;
import com.lcwd.user.service.userservice.repositories.UserRepository;
import com.lcwd.user.service.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private RestTemplate restTemplate;

    private Logger LOG = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserID = UUID.randomUUID().toString();
        user.setUserId(randomUserID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String UserId) {

        User user = userRepository.findById(UserId).orElseThrow(
                () -> new ResourceNotFoundException("user not found on the server ... please try again after a time"));

        LOG.info("karan******************************************");
        // localhost:9092/ratings/users/1cae8d9d-6dc8-483f-8cc3-7f84f4a39cbf
        Rating[] userRatingList = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(),
                Rating[].class);
                System.out.println(userRatingList);
                List<Rating> ratings = Arrays.stream(userRatingList).toList();
                LOG.info("{}", ratings);
                LOG.info("wow", ratings);
        //Getting Hotel List
        List<Rating> ratingList = ratings.stream().map(rating -> {
            // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            // Hotel hotel = forEntity.getBody();
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            // LOG.info("response statuscode : {}", forEntity.getStatusCode());
            LOG.info("Hotel : {}", hotel);
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }

}
