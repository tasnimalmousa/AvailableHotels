package com.tmousa.availablehotels.services.providers;

import com.tmousa.availablehotels.models.HotelRequest;
import com.tmousa.availablehotels.models.hotels.AvailableHotel;
import com.tmousa.availablehotels.models.hotels.Hotel;

import java.util.HashMap;
import java.util.List;

/**
 * The Provider Interface
 * A Service for Connecting to a provider
 *
 * @author  tmousa
 */
public interface Provider<T extends Hotel> {

    /**
     * getRequest
     * This method to send a request with no parameters to the provider
     *
     * @return string of Json of available hotels from the provider
     */
    String getRequest();

    /**
     * getRequest
     * This method to send a request with parameters to the provider
     *
     * @param params request params for the provider
     *
     * @return string of Json of available hotels from the provider
     */
    String getRequest(HashMap<String, String> params);

    /**
     * getAvailable
     * This method to get all available hotels from provider
     *
     * @return List of all available hotels from provider
     */
    List<AvailableHotel> getAvailable();

    /**
     * getAvailable
     * This method to get available hotels from provider filtered by parameters
     *
     * @param params parameters for the provider
     * @return List of available hotels from provider
     */
    List<AvailableHotel> getAvailable(HashMap<String, String> params);

    /**
     * getAvailable
     * This method to get available hotels from Json String
     *
     * @param hotelsString parameters for the provider
     * @return List of available hotels from provider
     */
    List<AvailableHotel> getAvailableHotels(String hotelsString);

    /**
     * getAvailable
     * This method to get hotels from Json String
     *
     * @param hotelsString parameters for the provider
     * @return List of hotels from provider
     */
    List<T> getHotels(String hotelsString);

    /**
     * getParams
     * This method get the map of parameters from HotelRequest
     * Converted to the provider parameters
     *
     * @param hotelRequest HotelRequest from App request
     * @return parameters for the provider
     */
    HashMap<String, String> getParams(HotelRequest hotelRequest);

}
