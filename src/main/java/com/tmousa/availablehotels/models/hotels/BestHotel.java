package com.tmousa.availablehotels.models.hotels;

import lombok.*;

/**
 * The BestHotel class
 * A model for representing a Best Hotel
 *
 * @author  tmousa
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BestHotel extends Hotel {
    private String hotel;

    private int hotelRate;
    private double hotelFare;

    private String roomAmenities;

    public double getHotelFare() {
        return hotelFare = (double) Math.round(hotelFare * 100) / 100;
    }
}
