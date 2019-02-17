package com.tmousa.availablehotels.models;

import com.tmousa.availablehotels.annotations.CheckDateFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * The HotelRequest class
 * A model for representing a request for the Available Hotels Service
 *
 * @author  tmousa
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelRequest {
    @NotBlank
    @Pattern(regexp = "^[A-Z]{3}$")
    String city;

    @CheckDateFormat(pattern = "YYYY-MM-DD")
    String fromDate;

    @CheckDateFormat(pattern = "YYYY-MM-DD")
    String toDate;

    @Pattern(regexp = "^[0-9]*$")
    String numberOfAdults;
}
