package com.tmousa.availablehotels.controllers;

import com.tmousa.availablehotels.models.HotelRequest;
import com.tmousa.availablehotels.services.available.AvailableHotelsService;
import com.tmousa.availablehotels.utils.URLs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * HomeController
 * Handles Get Request for Available hotels('/available/**')
 *
 * @author  tmousa
 */
@Controller
@RequestMapping("/available")
public class AvailableController {

    @Autowired
    AvailableHotelsService availableHotelsService;

    @GetMapping
    public String available(HttpServletRequest request) {
        return URLs.AVAILABLE.get();
    }

    @GetMapping("/availableHotels")
    @ResponseBody
    public String availableHotels(@Valid HotelRequest hotelRequest,
                                  HttpServletRequest request, HttpServletResponse response) throws IOException {
        return availableHotelsService.getAvailable(hotelRequest);
    }
}
