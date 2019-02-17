package com.tmousa.availablehotels.services.available;

import com.tmousa.availablehotels.models.HotelRequest;
import com.tmousa.availablehotels.models.hotels.AvailableHotel;

import java.util.List;

/**
 * The Available interface
 * A service for getting a available hotels from a provider
 *
 * @author  tmousa
 */
public interface Available {

    /**
     * getAvailable
     * This method gets available hotels from providers
     * parametrized by HotelRequest
     *
     * @param hotelRequest HotelRequest containing parameters
     *
     * @return Json string of available hotels
     */
    String getAvailable(HotelRequest hotelRequest);

    /**
     * getAvailableHotelsList
     * This method gets a list of available hotels from providers
     * parametrized by HotelRequest
     *
     * @param hotelRequest HotelRequest containing parameters
     *
     * @return list available hotels
     */
    List<AvailableHotel> getAvailableHotelsList(HotelRequest hotelRequest);

    /**
     * sortHotels
     * This method gets a list of available hotels from providers
     *
     * @param hotels List of Available hotels
     *
     * @return Sorted list of available hotels
     */
    List<AvailableHotel> sortHotels(List<AvailableHotel> hotels);

    /**
     * sortHotels
     * This method gets Json string of available hotels from providers
     *
     * @param hotels List of Available hotels
     *
     * @return Json string of available hotels
     */
    String getAvailableHotelsJson(List<AvailableHotel> hotels);
}
