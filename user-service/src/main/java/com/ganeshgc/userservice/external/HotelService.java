package com.ganeshgc.userservice.external;

import com.ganeshgc.userservice.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/api/hotels/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);

}
