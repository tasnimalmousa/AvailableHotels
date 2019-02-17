package com.tmousa.availablehotels.utils.sort;

import com.tmousa.availablehotels.models.hotels.AvailableHotel;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * The AvailableHotelsSorter class
 * Sorts a List of AvailableHotels
 *
 * @author  tmousa
 */
@Component
public class AvailableHotelsSorter implements Sorter<AvailableHotel> {

    /**
     * rate
     * This method gets the rate of a hotel
     *
     * @param hotel the available hotel
     *
     * @return The rate of the hotel
     */
    public static Integer rate(AvailableHotel hotel) {
        return hotel.getRate();
    }

    /**
     * fare
     * This method gets the fare of a hotel
     *
     * @param hotel the available hotel
     *
     * @return The fare of the hotel
     */
    public static Double fare(AvailableHotel hotel) {
        return hotel.getFare();
    }

    /**
     * amenities
     * This method gets the number of amenities of a hotel
     *
     * @param hotel the available hotel
     *
     * @return The number of amenities of the hotel
     */
    public static Integer amenities(AvailableHotel hotel) {
        return hotel.getAmenities().length;
    }

    /**
     * sort
     * This method sorts a List of hotels
     *
     * @param hotels List of hotels to be sorted
     *
     * @return List of sorted hotels
     */
    @Override
    public List<AvailableHotel> sort(List<AvailableHotel> hotels) {
        return sortHotels(hotels);
    }

    /**
     * sortHotels
     * This method sorts a List of hotels
     *
     * @param hotels List of hotels to be sorted
     *
     * @return List of sorted hotels
     */
    public List<AvailableHotel> sortHotels(List<AvailableHotel> hotels) {
        AvailableHotel[] availableHotels = hotels.toArray(new AvailableHotel[hotels.size()]);

        Arrays.sort(availableHotels, Comparator
                .comparing(AvailableHotelsSorter::rate)
                .thenComparing(AvailableHotelsSorter::fare)
                .reversed()
                .thenComparing(AvailableHotelsSorter::amenities));

        return Arrays.asList(availableHotels);
    }
}
