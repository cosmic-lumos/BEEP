package com.cosmic.beep.roles;

import com.cosmic.beep.controllers.RentController;
import com.cosmic.beep.dtos.RentCreateDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Log4j2
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
//@SpringBootTest
public class RentRoleTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @WithMockUser
    @Test
    public void noLoginUserRentTest(){
        try{
            this.mvc.perform(MockMvcRequestBuilders
                            .post("/api/rent/")
                            .content(objectMapper.writeValueAsString(new RentCreateDto(153L)))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @WithMockUser(username = "testman", roles = {"USER"})
    @Test
    public void userRentTest(){
        try{
            this.mvc.perform(MockMvcRequestBuilders
                            .post("/api/rent/")
                            .content(objectMapper.writeValueAsString(new RentCreateDto(153L)))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
