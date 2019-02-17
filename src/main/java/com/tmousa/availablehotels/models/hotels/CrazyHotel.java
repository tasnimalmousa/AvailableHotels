package com.tmousa.availablehotels.models.hotels;

import lombok.*;

/**
 * The CrazyHotel class
 * A model for representing a Crazy Hotel
 *
 * @author  tmousa
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CrazyHotel extends Hotel {
    private String HotelName;

    private String rate;

    private double price;
    private double discount;

    private String[] amenities;
}
