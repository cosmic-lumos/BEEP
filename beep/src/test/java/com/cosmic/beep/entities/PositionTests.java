package com.cosmic.beep.entities;

import com.cosmic.beep.dtos.NameOnlyDto;
import com.cosmic.beep.exceptions.ResourceNotFound;
import com.cosmic.beep.repositories.PositionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Log4j2
@ActiveProfiles("test")
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.class)
public class PositionTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PositionRepository positionRepository;

    @WithMockUser(username = "testman")
    @Test
    @Order(1)
    public void createPositionFailTest(){
        try {
            this.mvc.perform(MockMvcRequestBuilders
                    .post("/api/positions/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(new NameOnlyDto("testPosition"))))
                    .andDo(print())
                    .andExpect(status().isForbidden());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @WithMockUser(username = "admin", roles = {"ADMIN"})
    @Test
    @Order(2)
    public void createPositionSuccessTest(){
        try {
            this.mvc.perform(MockMvcRequestBuilders
                            .post("/api/positions/")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(new NameOnlyDto("testPosition"))))
                    .andDo(print())
                    .andExpect(status().isOk());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @WithMockUser(username = "admin", roles = {"ADMIN"})
    @Test
    @Order(3)
    public void deletePositionSuccessTest(){
        try{
            this.mvc.perform(MockMvcRequestBuilders
                    .delete("/api/positions/{id}", positionRepository.findByName("testPosition").get().getId()))
                    .andDo(print())
                    .andExpect(status().isOk());
        } catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Test
    @Order(4)
    public void deletePositionByNameTest(){
        try{
            if(positionRepository.findByName("testPosition").isEmpty()){
                throw new ResourceNotFound(1L);
            }
            positionRepository.deleteById(positionRepository.findByName("testPosition").get().getId());
            log.info("성공적 삭제");
        } catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
