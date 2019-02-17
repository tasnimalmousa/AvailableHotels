package com.tmousa.availablehotels.services.providers;


import com.tmousa.availablehotels.models.HotelRequest;
import com.tmousa.availablehotels.models.hotels.AvailableHotel;
import com.tmousa.availablehotels.models.hotels.CrazyHotel;
import com.tmousa.availablehotels.utils.DateConverter;
import com.tmousa.availablehotels.utils.JsonConverter;
import com.tmousa.availablehotels.utils.RestClient;
import com.tmousa.availablehotels.utils.converter.CrazyHotelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * The CrazyHotelsProvider class
 * A Service for Connecting to a CrazyHotels Provider
 *
 * @author  tmousa
 */
@Service
@Configurable
public class CrazyHotelsProvider implements Provider<CrazyHotel> {
    public final String URL = "http://localhost:9092/crazyHotels";
    @Autowired
    RestClient restClient;
    @Autowired
    JsonConverter jsonConverter;
    @Autowired
    CrazyHotelConverter crazyHotelConverter;

    @Override
    public String getRequest() {
        return restClient.get(URL);
    }

    @Override
    public String getRequest(HashMap<String, String> params) {
        return restClient.get(URL, params);
    }

    @Override
    public List<AvailableHotel> getAvailable() {
        String hotelsString = getRequest();
        return getAvailableHotels(hotelsString);
    }

    @Override
    public List<AvailableHotel> getAvailable(HashMap<String, String> params) {
        String hotelsString = getRequest(params);
        return getAvailableHotels(hotelsString);
    }

    @Override
    public List<AvailableHotel> getAvailableHotels(String hotelsString) {
        List<AvailableHotel> availableHotels = new ArrayList<>();
        getHotels(hotelsString).forEach(bestHotel -> {
            availableHotels.add(crazyHotelConverter.convert(bestHotel));
        });
        return availableHotels;
    }

    @Override
    public List<CrazyHotel> getHotels(String hotelsString) {
        try {
            return (List<CrazyHotel>) jsonConverter.fromJson(hotelsString, CrazyHotel.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public HashMap<String, String> getParams(HotelRequest hotelRequest) {
        HashMap<String, String> params = new HashMap<>();

        Optional.ofNullable(hotelRequest.getCity()).ifPresent(cityOpt -> {
            params.put("city", cityOpt);
        });

        Optional.ofNullable(hotelRequest.getFromDate()).ifPresent(fromDateOpt -> {
            params.put("from", DateConverter.toIsoInstant(fromDateOpt));
        });

        Optional.ofNullable(hotelRequest.getToDate()).ifPresent(toDateOpt -> {
            params.put("to", DateConverter.toIsoInstant(toDateOpt));
        });

        Optional.ofNullable(hotelRequest.getNumberOfAdults()).ifPresent(numberOfAdultsOpt -> {
            params.put("adultsCount", numberOfAdultsOpt);
        });

        return params;
    }
}
