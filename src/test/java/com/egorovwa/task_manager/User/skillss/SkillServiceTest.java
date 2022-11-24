package com.egorovwa.task_manager.User.skillss;

import com.egorovwa.task_manager.dto.position.PositionCreateDto;
import com.egorovwa.task_manager.dto.skills.SkillCreateDto;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SkillServiceTest {
    ObjectMapper mapper = new ObjectMapper();


    @Test
    void addNewSkill() throws JsonProcessingException {
        PositionCreateDto createDto = new PositionCreateDto(
                "Владелец",
                "Проклятый капиталист",
                "GENERAL",
                List.of(3L)

        );
        System.out.println(mapper.writeValueAsString(createDto));
    }

    @Test
    void getAllSkil() {
    }

    @Test
    void getSkilById() {
    }

    @Test
    void findAllByIds() {
    }
}