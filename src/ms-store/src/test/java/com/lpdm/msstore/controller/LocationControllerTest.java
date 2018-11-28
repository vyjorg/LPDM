package com.lpdm.msstore.controller;

import com.lpdm.msstore.entity.Location;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class LocationControllerTest {

    @Mock
    private LocationController locationController;

    private MockMvc mockMvc;

    @Before
    public void init(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(locationController).build();
    }

    @Test
    public void findLocationById() throws Exception {

        Location location = new Location();
        location.setId(1);
        location.setStreetName("rue des tests");

        Mockito.when(locationController.findLocationById(1)).thenReturn(location);

        mockMvc.perform(get("/locations/1")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("streetName", is("rue des tests")));

        Mockito.verify(locationController, Mockito.times(1)).findLocationById(1);
        Mockito.verifyNoMoreInteractions(locationController);
    }
}
