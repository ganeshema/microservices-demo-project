package com.ganeshgc.rating_service.service;

import com.ganeshgc.rating_service.entities.Rating;

import java.util.List;

public interface RatingService {
    Rating addRating(Rating rating);
    List<Rating> getRatings();
    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByHotelId(String hotelId);

}
