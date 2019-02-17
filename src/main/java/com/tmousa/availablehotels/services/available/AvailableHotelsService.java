package com.tmousa.availablehotels.services.available;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tmousa.availablehotels.models.HotelRequest;
import com.tmousa.availablehotels.models.hotels.AvailableHotel;
import com.tmousa.availablehotels.services.providers.Provider;
import com.tmousa.availablehotels.utils.JsonConverter;
import com.tmousa.availablehotels.utils.sort.AvailableHotelsSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The AvailableHotelsService class
 * A service for getting a available hotels from a provider
 *
 * @author  tmousa
 */
@Service
@Configurable
public class AvailableHotelsService implements Available {

    @Autowired
    Providers providers;

    @Autowired
    JsonConverter jsonConverter;

    @Autowired
    AvailableHotelsSorter availableHotelsSorter;

    /**
     * getAvailable
     * This method gets available hotels from providers
     * parametrized by HotelRequest
     *
     * @param hotelRequest HotelRequest containing parameters
     *
     * @return Json string of available hotels
     */
    @Override
    public String getAvailable(HotelRequest hotelRequest) {
        List<AvailableHotel> availableHotels = getAvailableHotelsList(hotelRequest);
        availableHotels = sortHotels(availableHotels);
        return getAvailableHotelsJson(availableHotels);
    }

    /**
     * getAvailableHotelsList
     * This method gets a list of available hotels from providers
     * parametrized by HotelRequest
     *
     * @param hotelRequest HotelRequest containing parameters
     *
     * @return list available hotels
     */
    @Override
    public List<AvailableHotel> getAvailableHotelsList(HotelRequest hotelRequest) {
        List<AvailableHotel> hotels = new ArrayList<>();

        for (Provider provider : providers.getProviders()) {
            provider.getAvailable(provider.getParams(hotelRequest))
                    .forEach(hotel -> hotels.add((AvailableHotel) hotel));
        }

        return hotels;
    }

    /**
     * sortHotels
     * This method gets a list of available hotels from providers
     *
     * @param hotels List of Available hotels
     *
     * @return Sorted list of available hotels
     */
    @Override
    public List<AvailableHotel> sortHotels(List<AvailableHotel> hotels) {
        return availableHotelsSorter.sort(hotels);
    }

    /**
     * sortHotels
     * This method gets Json string of available hotels from providers
     *
     * @param hotels List of Available hotels
     *
     * @return Json string of available hotels
     */
    @Override
    public String getAvailableHotelsJson(List<AvailableHotel> hotels) {
        try {
            return jsonConverter.toJson(hotels);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }


}
