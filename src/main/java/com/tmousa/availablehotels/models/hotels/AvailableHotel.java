package com.tmousa.availablehotels.models.hotels;

import lombok.*;


/**
 * The AvailableHotel class
 * A model for representing a Available Hotel
 *
 * @author  tmousa
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AvailableHotel implements Comparable<AvailableHotel> {

    private String provider;
    private String hotelName;
    private double fare;

    private String[] amenities;

    private int rate;


    @Override
    public int compareTo(AvailableHotel availableHotel) {
        return availableHotel.getRate() - getRate();
    }
}
