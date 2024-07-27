package com.ganeshgc.userservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    private String hotelId;
    private String hotelName;
    private String hotelAddress;
    private String about;
}
