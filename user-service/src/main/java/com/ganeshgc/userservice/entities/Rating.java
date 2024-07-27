package com.ganeshgc.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private String rating;
    private String feedback;
    private Hotel hotel;
}
