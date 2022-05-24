package com.luhpaglia.translucentapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luhpaglia.translucentapi.dao.GameDAO;
import com.luhpaglia.translucentapi.dao.GamePutDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTests {

    @Autowired
    MockMvc mock;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void getAllGamesTest() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void postGamesTest() throws Exception {
        GameDAO test = new GameDAO("Kingdom Herats", "PS4", true, "2018-05-04", "", 5, 2018, "www.urlimg.com");
        mock.perform(MockMvcRequestBuilders.post("/")
                .contentType("application/json")
                .content(mapper.writeValueAsString(test)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void putGamesTest() throws Exception {
        GameDAO test = new GameDAO("Kingdom Herats", "PS4", true, "2018-05-04", "", 5, 2018, "www.urlimg.com");
        mock.perform(MockMvcRequestBuilders.post("/")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(test)))
                .andExpect(MockMvcResultMatchers.status().isOk());
        GamePutDAO update = new GamePutDAO(1, false, "2022-05-02", "", 5, "www.urlImg.com");
        mock.perform(MockMvcRequestBuilders.put("/")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(update)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteGamesTest() throws Exception {
        GameDAO test = new GameDAO("Kingdom Herats", "PS4", true, "2018-05-04", "", 5, 2018, "www.urlimg.com");
        mock.perform(MockMvcRequestBuilders.post("/")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(test)))
                .andExpect(MockMvcResultMatchers.status().isOk());
        mock.perform(MockMvcRequestBuilders.delete("/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
