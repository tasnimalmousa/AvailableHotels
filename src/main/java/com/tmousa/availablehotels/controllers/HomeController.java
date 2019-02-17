package com.tmousa.availablehotels.controllers;


import com.tmousa.availablehotels.utils.URLs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * HomeController
 * Handles Request for the Home('/') of the Available Hotels App
 *
 * @author  tmousa
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(HttpServletRequest request) {
        return URLs.HOME.get();
    }
}
