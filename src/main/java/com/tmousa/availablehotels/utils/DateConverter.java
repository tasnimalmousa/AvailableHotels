package com.tmousa.availablehotels.utils;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The DateConverter class
 * This class is for date format conversion between ISO_LOCALE_DATE and ISO_INSTANT formats
 *
 * @author  tmousa
 */
@Component
public class DateConverter {

    public static final String ISO_LOCALE_DATE = "YYYY-MM-DD";
    public static final String ISO_INSTANT = "yyyy-MM-dd'T'HH:mm:ss.SSSX";


    /**
     * toIsoLocaleDate
     * This method converts a date string of ISO_INSTANT format to ISO_LOCALE_DATE format
     *
     * @param dateString date string of ISO_INSTANT format
     *
     * @return date string of ISO_LOCALE_DATE format
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static String toIsoLocaleDate(String dateString) {
        Date date = null;
        try {
            date = new SimpleDateFormat(ISO_INSTANT).parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Wrong Date format: " + dateString);
        }
        return new SimpleDateFormat(ISO_LOCALE_DATE).format(date);
    }

    /**
     * toIsoInstant
     * This method converts a date string of ISO_LOCALE_DATE format to ISO_INSTANT format
     *
     * @param dateString date string of ISO_LOCALE_DATE format
     *
     * @return date string of ISO_INSTANT format
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static String toIsoInstant(String dateString) {
        Date date = null;
        try {
            date = new SimpleDateFormat(ISO_LOCALE_DATE).parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Wrong Date format: " + dateString);
        }
        return new SimpleDateFormat(ISO_INSTANT).format(date);
    }
}
