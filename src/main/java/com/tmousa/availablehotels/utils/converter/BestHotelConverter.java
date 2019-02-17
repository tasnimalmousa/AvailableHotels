package com.tmousa.availablehotels.utils.converter;

import com.tmousa.availablehotels.models.hotels.AvailableHotel;
import com.tmousa.availablehotels.models.hotels.BestHotel;
import org.springframework.stereotype.Component;

/**
 * The CrazyHotelConverter class
 * Converts A Hotel of type BestHotel to AvailableHotel
 *
 * @author  tmousa
 */
@Component
public class BestHotelConverter implements HotelConverter<BestHotel> {

    /**
     * convert
     * This method Converts A Hotel of type CrazyHotel to AvailableHotel
     *
     * @param bestHotel BestHotel to be converted
     *
     * @return converted AvailableHotel
     */
    @Override
    public AvailableHotel convert(BestHotel bestHotel) {
        AvailableHotel hotel = AvailableHotel.builder()
                .provider("BestHotels")
                .hotelName(bestHotel.getHotel())
                .fare(bestHotel.getHotelFare())
                .amenities(bestHotel.getRoomAmenities().split(","))
                .rate(bestHotel.getHotelRate())
                .build();

        return hotel;
    }


}
