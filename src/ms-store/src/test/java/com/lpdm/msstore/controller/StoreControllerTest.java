package com.lpdm.msstore.controller;

import com.lpdm.msstore.entity.Store;
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
public class StoreControllerTest {

    @Mock
    private StoreController storeController;

    private MockMvc mockMvc;

    @Before
    public void init(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(storeController).build();
    }

    @Test
    public void getStoreById() throws Exception {

        Store store = new Store();
        store.setId(1);
        store.setName("chez paulette");

        Mockito.when(storeController.getStoreById(1)).thenReturn(store);

        mockMvc.perform(get("/stores/1")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("name", is("chez paulette")));

        Mockito.verify(storeController, Mockito.times(1)).getStoreById(1);
        Mockito.verifyNoMoreInteractions(storeController);
    }
}
