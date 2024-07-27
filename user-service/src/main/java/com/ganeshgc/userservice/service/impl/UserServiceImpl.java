package com.ganeshgc.userservice.service.impl;


import com.ganeshgc.userservice.entities.Hotel;
import com.ganeshgc.userservice.entities.Rating;
import com.ganeshgc.userservice.entities.User;
import com.ganeshgc.userservice.exception.ResourceNotFoundException;
import com.ganeshgc.userservice.external.HotelService;
import com.ganeshgc.userservice.repository.UserRepository;
import com.ganeshgc.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private HotelService hotelService;
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    private RestTemplate restTemplate;

    private Logger LOGGER= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getUserById(String id) {
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
        Rating [] ratings=restTemplate.getForObject("http://RATING-SERVICE/api/ratings/users/"+user.getUserId(), Rating[].class);
        LOGGER.info("{}",ratings);

        List<Rating> ratingList= Arrays.stream(ratings).toList();

        List<Rating> ratingList1=ratingList.stream().map(rating->{
            //ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/api/hotels/"+rating.getHotelId(), Hotel.class);
            //Hotel hotel=forEntity.getBody();
            Hotel hotel=hotelService.getHotel(rating.getHotelId());
            //LOGGER.info("{}",forEntity.getStatusCode());
            rating.setHotel(hotel);
            return rating;}).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;

    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        String randomUserId=UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);

    }

    @Override
    public User updateUser(String id, User user) {
        User user1=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
        user1.setUserName(user.getUserName());
        user1.setEmail(user.getEmail());
        user1.setAbout(user.getAbout());
        return userRepository.save(user1);
    }

    @Override
    public void deleteUser(String id) {

        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
        if(user!=null){
            userRepository.delete(user);
        }
    }
}
