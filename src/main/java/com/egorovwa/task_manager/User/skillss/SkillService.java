package com.egorovwa.task_manager.User.skillss;

import com.egorovwa.task_manager.dto.skills.SkillCreateDto;
import com.egorovwa.task_manager.dto.skills.SkillFullDto;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import com.egorovwa.task_manager.exceptions.NotFoundException;
import org.springframework.data.domain.Page;

public interface SkillService {
    SkillFullDto addNewSkill(SkillCreateDto createDto) throws AlreadyExists;

    Page<SkillFullDto> getAllSkil(Integer from, Integer size);

    SkillFullDto getSkilById(Long id) throws NotFoundException;
}
