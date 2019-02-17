package com.tmousa.availablehotels.utils.converter;

import com.tmousa.availablehotels.models.hotels.AvailableHotel;
import com.tmousa.availablehotels.models.hotels.Hotel;

/**
 * The HotelConverter Interface
 * A Service for Converting between Hotel types
 *
 * @author  tmousa
 */
public interface HotelConverter<T extends Hotel> extends TypeConverter<AvailableHotel, T> {

}
