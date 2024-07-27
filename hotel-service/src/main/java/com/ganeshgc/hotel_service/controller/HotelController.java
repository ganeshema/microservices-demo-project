package com.ganeshgc.hotel_service.controller;

import com.ganeshgc.hotel_service.entities.Hotel;
import com.ganeshgc.hotel_service.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    private final HotelService hotelService;
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> hotels() {
        hotelService.getAllHotels();
        return ResponseEntity.ok(hotelService.getAllHotels());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id) {
        hotelService.getHotelById(id);
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }
    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable String id) {
        hotelService.deleteHotelById(id);
    }
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        hotelService.saveHotel(hotel);
        return ResponseEntity.ok(hotel);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String id, @RequestBody Hotel hotel) {
        hotelService.updateHotel(id, hotel);
        return ResponseEntity.ok(hotel);
    }
}
