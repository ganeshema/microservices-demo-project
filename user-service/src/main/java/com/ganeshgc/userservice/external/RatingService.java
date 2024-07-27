package com.ganeshgc.userservice.external;

import com.ganeshgc.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

    //get

    //post
    @PostMapping()
    Rating addRating(@RequestBody Rating rating);
    //delete
    @DeleteMapping("/api/ratings/{ratingId")
    Rating deleteRating(@PathVariable("ratingId") String ratingId);
    @PutMapping("/api/ratings/{ratingId")
    Rating updateRating(@PathVariable("ratingId") String ratingId, @RequestBody Rating rating);

}
