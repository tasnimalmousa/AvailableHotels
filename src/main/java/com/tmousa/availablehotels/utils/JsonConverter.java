package com.tmousa.availablehotels.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.util.List;

/**
 * The JsonConverter class
 * This class is for conversion operation of Object/JsonString
 *
 * @author  tmousa
 */
@Component
public class JsonConverter {

    private ObjectMapper mapper;

    /**
     * Constructor
     */
    public JsonConverter() {
        mapper = new ObjectMapper();
    }

    /**
     * toJson
     * This method converts an object to Json String
     *
     * @param object the object to be converted
     *
     * @return Json String
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String toJson(Object object) throws JsonProcessingException {
        String hotelsJSON = mapper.writeValueAsString(object);
        return hotelsJSON;
    }

    /**
     * fromJson
     * This method converts Json String to an object
     *
     * @param jsonString the string to get the object of
     * @param classType the type of object to convert to
     *
     * @return Json String
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object fromJson(String jsonString, Class classType) throws IOException {
        //return mapper.readValue(jsonString, new TypeReference<List<classType>>(){});
        return mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, classType));
    }
}
