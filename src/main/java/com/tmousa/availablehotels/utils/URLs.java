package com.tmousa.availablehotels.utils;

import lombok.ToString;

/**
 * The URLs enum
 * Provides constants for pages urls
 *
 * @author  tmousa
 */
@ToString
public enum URLs {
    HOME("home"),
    AVAILABLE("available");

    private String url;

    /**
     * Constructor
     */
    URLs(String url) {
        this.url = url;
    }

    /**
     * get
     * This method returns the URL as a String
     *
     * @return string of the URL
     */
    public String get() {
        return this.url;
    }

    /**
     * redirect
     * This method returns the URL as a String with 'redirect:/' as prefix
     *
     * @return string of the URL redirect
     */
    public String redirect() {
        return "redirect:/" + this.url;
    }
}
