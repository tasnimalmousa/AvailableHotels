package com.tmousa.availablehotels.services.available;

import com.tmousa.availablehotels.services.providers.BestHotelsProvider;
import com.tmousa.availablehotels.services.providers.CrazyHotelsProvider;
import com.tmousa.availablehotels.services.providers.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The Providers class
 * Initializes the providers for the AvailableHotelService
 *
 * @author  tmousa
 */
@Component
public class Providers {

    @Autowired
    private CrazyHotelsProvider crazyHotelsProvider;
    @Autowired
    private BestHotelsProvider bestHotelsProvider;

    private List<Provider> providers;

    /**
     * getProviders
     * This method gets Json string of available hotels from providers
     *
     * @return A list of providers
     */
    public List<Provider> getProviders() {
        if (providers == null) {
            providers = new ArrayList<>();

            providers.add(crazyHotelsProvider);
            providers.add(bestHotelsProvider);
        }

        return providers;
    }
}
