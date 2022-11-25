package com.egorovwa.task_manager.User.skillss;

import com.egorovwa.task_manager.dto.position.PositionCreateDto;
import com.egorovwa.task_manager.dto.skills.SkillCreateDto;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import com.egorovwa.task_manager.model.Skill;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SkillServiceTest {
    @Mock
    SkillRepository skillRepository;
    @InjectMocks
    SkillServiceImpl skillService;
    @Test
    void  test1_addNewSkill() throws AlreadyExists {
        SkillCreateDto skillCreateDto = new SkillCreateDto("title", "description", false);
        Skill skill = new Skill(null,"title", "description", false);
        Skill skillWithId = new Skill(1L,"title", "description", false);
        when(skillRepository.save(skill))
                .thenReturn(skillWithId);
        skillService.addNewSkill(skillCreateDto, UUID.randomUUID());
        verify(skillRepository,times(1)).save(skill);

    }

    @Test
    void getAllSkil() {
        Skill skill = new Skill(null,"title", "description", false);
        Pageable pageable = PageRequest.of(0,10);
        Page<Skill> page = new PageImpl<>(List.of(skill));
        when(skillRepository.findAll(pageable))
                .thenReturn(page);

    }

    @Test
    void getSkilById() {
    }

    @Test
    void findAllByIds() {
    }
}