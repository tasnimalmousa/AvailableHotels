package com.tmousa.availablehotels.utils.converter;

import com.tmousa.availablehotels.models.hotels.AvailableHotel;
import com.tmousa.availablehotels.models.hotels.CrazyHotel;
import org.springframework.stereotype.Component;

/**
 * The CrazyHotelConverter class
 * Converts A Hotel of type CrazyHotel to AvailableHotel
 *
 * @author  tmousa
 */
@Component
public class CrazyHotelConverter implements HotelConverter<CrazyHotel> {

    /**
     * convert
     * This method Converts A Hotel of type CrazyHotel to AvailableHotel
     *
     * @param crazyHotel CrazyHotel to be converted
     *
     * @return converted AvailableHotel
     */
    @Override
    public AvailableHotel convert(CrazyHotel crazyHotel) {
        AvailableHotel hotel = AvailableHotel.builder()
                .provider("CrazyHotels")
                .hotelName(crazyHotel.getHotelName())
                .fare(crazyHotel.getPrice() - (crazyHotel.getPrice() * crazyHotel.getDiscount()))
                .amenities(crazyHotel.getAmenities())
                .rate(getRate(crazyHotel))
                .build();

        return hotel;
    }

    private int getRate(CrazyHotel crazyHotel) {
        return crazyHotel.getRate().length();
    }
}
