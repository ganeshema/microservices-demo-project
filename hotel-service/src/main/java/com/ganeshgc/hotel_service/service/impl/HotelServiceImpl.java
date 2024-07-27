package com.ganeshgc.hotel_service.service.impl;

import com.ganeshgc.hotel_service.entities.Hotel;
import com.ganeshgc.hotel_service.exception.ResourceNotFoundException;
import com.ganeshgc.hotel_service.repository.HotelRepository;
import com.ganeshgc.hotel_service.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    @Override
    public Hotel saveHotel(Hotel hotel) {
        String randomId=UUID.randomUUID().toString();
        hotel.setHotelId(randomId);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        Hotel hotel=hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException(hotelId));
        return hotel;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public void deleteHotelById(String hotelId) {
        hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException(hotelId));
        hotelRepository.deleteById(hotelId);
    }

    @Override
    public Hotel updateHotel(String hotelId, Hotel hotel) {
        Hotel hotel1=hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException(hotelId));
        hotel1.setHotelName(hotel.getHotelName());
        hotel1.setHotelAddress(hotel.getHotelAddress());
        hotel1.setAbout(hotel.getAbout());
        return hotel1;
    }
}
