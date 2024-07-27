package com.ganeshgc.hotel_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="hotels")
public class Hotel {
    @Id
    private String hotelId;
    private String hotelName;
    private String hotelAddress;
    private String about;
}
