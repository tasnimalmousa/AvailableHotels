package com.tmousa.availablehotels;

import static org.assertj.core.api.Assertions.assertThat;

import com.tmousa.availablehotels.controllers.AvailableController;
import com.tmousa.availablehotels.controllers.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private HomeController homeController;

    @Autowired
    private AvailableController availableController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(homeController).isNotNull();
        assertThat(availableController).isNotNull();
    }
}
