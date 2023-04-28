package com.wcci.virtualPetAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wcci.virtualPetAPI.entities.VirtualPetShelter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureTestDatabase
@DirtiesContext
@AutoConfigureMockMvc
public class ShelterControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getShelter() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/shelters").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{},{}]")));
    }

    @Test
    public void addShelter() throws Exception {
        final VirtualPetShelter shelter = new VirtualPetShelter();
        mvc.perform(MockMvcRequestBuilders.post("/shelters")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getJsonContent(shelter)))
                .andExpect(status().isOk());
    }

    @Test
    public void addShelters() throws Exception {
        final VirtualPetShelter shelter1 = new VirtualPetShelter();
        final VirtualPetShelter shelter2 = new VirtualPetShelter();

        mvc.perform(MockMvcRequestBuilders.post("/shelters")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(getJsonContent(shelter1)))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.post("/shelters")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(getJsonContent(shelter2)))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/shelters").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(getJsonContent(new VirtualPetShelter[]{shelter1, shelter2})));
    }



    private String getJsonContent(Object o) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(o);
    }
}


