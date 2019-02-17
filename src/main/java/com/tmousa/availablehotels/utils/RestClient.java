package com.tmousa.availablehotels.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Optional;

/**
 * The RestClient class
 * Sends a get Request to a provider
 *
 * @author  tmousa
 */
@Component
public class RestClient {

    /**
     * get
     * This method sends a get request with no parameters to a client
     *
     * @param clientUrl url of client
     *
     * @return String containing the response from the client
     */
    public String get(String clientUrl) {
        return get(clientUrl, null);
    }

    /**
     * get
     * This method sends a get request with parameters to a client
     *
     * @param clientUrl url of client
     * @params a map of the get request parameters
     *
     * @return String contaning the response from the client
     */
    public String get(String clientUrl, HashMap<String, String> params) {
        try {

            String paramsString = "";
            if (params != null && !params.isEmpty()) {
                paramsString = getParamsString(params);
            }

            URL url = new URL(clientUrl + paramsString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                StringBuilder sb = new StringBuilder();
                System.out.println("Output from Server .... \n");
                while (br.ready()) {
                    sb.append(br.readLine());
                }
                conn.disconnect();
                return sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * getParamsString
     * This method returns the get parameters a a string
     *
     * @params a map of the get request parameters
     *
     * @return String containing parameters of the request
     */
    private String getParamsString(HashMap<String, String> params) {
        StringBuilder sb = new StringBuilder();
        Optional.of(params).ifPresent(paramsOpt -> {
            paramsOpt.forEach((k, v) -> {
                try {
                    sb.append("&").append(k).append("=");
                    sb.append(URLEncoder.encode(v, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    sb.append(v);
                }
            });
            sb.replace(0, 1, "?");
        });
        return sb.toString();
    }

}