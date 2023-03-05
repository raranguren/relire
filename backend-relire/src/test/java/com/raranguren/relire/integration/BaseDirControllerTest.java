package com.raranguren.relire.integration;

import com.raranguren.relire.config.SecurityConfiguration;
import com.raranguren.relire.controller.BaseDirController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes={SecurityConfiguration.class, BaseDirController.class})
public class BaseDirControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void base_api_url_does_not_authenticate() throws Exception {
        mockMvc.perform(get("/api/v1"))
                .andExpect(status().is2xxSuccessful());
    }

}
