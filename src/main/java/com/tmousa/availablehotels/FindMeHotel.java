package com.tmousa.availablehotels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * <h1>FindMeHotel</h1>
 *
 * “FindMeHotel” is a hotel search solution that look into many providers
 * and display results from all the available hotels, for now we are aggregate
 * from 2 providers: “BestHotels” & “CrazyHotel”
 *
 * @author  tmousa
 */
@SpringBootApplication
public class FindMeHotel {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FindMeHotel.class, args);
    }
}
