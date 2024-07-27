package com.ganeshgc.rating_service.controller;

import com.ganeshgc.rating_service.entities.Rating;
import com.ganeshgc.rating_service.service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    private final RatingService ratingService;
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.ok(ratingService.getRatings());
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }
    @PostMapping
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
        return ResponseEntity.ok(ratingService.addRating(rating));
    }

}
