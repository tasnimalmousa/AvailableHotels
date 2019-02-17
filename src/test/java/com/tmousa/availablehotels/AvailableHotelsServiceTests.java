package com.tmousa.availablehotels;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tmousa.availablehotels.models.HotelRequest;
import com.tmousa.availablehotels.models.hotels.AvailableHotel;
import com.tmousa.availablehotels.models.hotels.CrazyHotel;
import com.tmousa.availablehotels.services.available.Available;
import com.tmousa.availablehotels.services.available.AvailableHotelsService;
import com.tmousa.availablehotels.services.available.Providers;
import com.tmousa.availablehotels.services.providers.BestHotelsProvider;
import com.tmousa.availablehotels.services.providers.CrazyHotelsProvider;
import com.tmousa.availablehotels.services.providers.Provider;
import com.tmousa.availablehotels.utils.JsonConverter;
import com.tmousa.availablehotels.utils.RestClient;
import com.tmousa.availablehotels.utils.sort.AvailableHotelsSorter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AvailableHotelsServiceTests extends AbstractTest{

    @Autowired
    @InjectMocks
    private AvailableHotelsService availableHotelsService;

    @Mock
    JsonConverter jsonConverter;

    @Mock
    AvailableHotelsSorter availableHotelsSorter;

    @Spy
    @InjectMocks
    Providers providers;

    @Mock
    BestHotelsProvider bestHotelsProvider;

    @Mock
    CrazyHotelsProvider crazyHotelsProvider;

    @Mock
    RestClient restClient;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAvailableHotelsJson() throws JsonProcessingException {
        AvailableHotel availableHotel = AvailableHotel.builder()
                .hotelName("Crazy Hotel 1")
                .provider("Crazy Hotels")
                .amenities(new String[]{"TV", "Pool"})
                .fare(100)
                .rate(5)
                .build();

        List<AvailableHotel> availableHotels = Arrays.asList(availableHotel);

        when(jsonConverter.toJson(availableHotels)).thenReturn(mapToJson(availableHotels));

        String availableHotelsString = availableHotelsService.getAvailableHotelsJson(availableHotels);
        assertEquals(availableHotelsString, mapToJson(availableHotels));
    }

    @Test
    public void sortHotels() {
        AvailableHotel availableHotel1 = AvailableHotel.builder()
                .hotelName("Crazy Hotel 1")
                .provider("Crazy Hotels")
                .amenities(new String[]{"TV", "Pool"})
                .fare(100)
                .rate(5)
                .build();

        AvailableHotel availableHotel2 = AvailableHotel.builder()
                .hotelName("Crazy Hotel 2")
                .provider("Crazy Hotels")
                .amenities(new String[]{"TV", "Pool"})
                .fare(100)
                .rate(1)
                .build();

        List<AvailableHotel> availableHotels = Arrays.asList(availableHotel1, availableHotel2);
        List<AvailableHotel> availableHotelsSorted = Arrays.asList(availableHotel2, availableHotel1);

        when(availableHotelsSorter.sort(availableHotels)).thenReturn(availableHotelsSorted);

        List<AvailableHotel> availableHotelsSortedMocked = availableHotelsService.sortHotels(availableHotels);
        Assert.assertEquals(availableHotelsSortedMocked, availableHotelsSorted);
    }

    @Test
    public void getAvailableHotelsList() {
        HotelRequest hotelRequest = HotelRequest.builder()
                .city("AMM")
                .numberOfAdults("3")
                .fromDate("2016-01-01")
                .toDate("2018-01-01")
                .build();

        AvailableHotel availableHotel = AvailableHotel.builder()
                .hotelName("Crazy Hotel 1")
                .provider("Crazy Hotels")
                .amenities(new String[]{"TV", "Pool"})
                .fare(100)
                .rate(5)
                .build();

        List<AvailableHotel> availableHotels = Arrays.asList(availableHotel);

        when(crazyHotelsProvider.getAvailable(Mockito.any())).thenReturn(availableHotels);
        when(bestHotelsProvider.getAvailable(Mockito.any())).thenReturn(new ArrayList<>());

        List<AvailableHotel> availableHotelsList = availableHotelsService.getAvailableHotelsList(hotelRequest);
        Assert.assertEquals(availableHotelsList, availableHotels);

    }

    @Test
    public void getAvailable() throws JsonProcessingException {
        HotelRequest hotelRequest = HotelRequest.builder()
                .city("AMM")
                .numberOfAdults("3")
                .fromDate("2016-01-01")
                .toDate("2018-01-01")
                .build();

        AvailableHotel availableHotel = AvailableHotel.builder()
                .hotelName("Crazy Hotel 1")
                .provider("Crazy Hotels")
                .amenities(new String[]{"TV", "Pool"})
                .fare(100)
                .rate(5)
                .build();

        List<AvailableHotel> availableHotels = Arrays.asList(availableHotel);

        when(crazyHotelsProvider.getAvailable(Mockito.any())).thenReturn(availableHotels);
        when(bestHotelsProvider.getAvailable(Mockito.any())).thenReturn(new ArrayList<>());
        when(jsonConverter.toJson(availableHotels)).thenReturn(mapToJson(availableHotels));
        when(availableHotelsSorter.sort(availableHotels)).thenReturn(availableHotels);

        String availableHotelsJsonString = availableHotelsService.getAvailable(hotelRequest);
        Assert.assertEquals(availableHotelsJsonString, mapToJson(availableHotels));

    }
}
