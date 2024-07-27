package com.ganeshgc.hotel_service.service;

import com.ganeshgc.hotel_service.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel saveHotel(Hotel hotel);
    Hotel getHotelById(String hotelId);
    List<Hotel> getAllHotels();
    void deleteHotelById(String hotelId);
    Hotel updateHotel(String hotelId, Hotel hotel);


}
