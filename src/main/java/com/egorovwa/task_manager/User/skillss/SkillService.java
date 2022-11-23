package com.egorovwa.task_manager.User.skillss;

import com.egorovwa.task_manager.dto.skills.SkillCreateDto;
import com.egorovwa.task_manager.dto.skills.SkillFullDto;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import com.egorovwa.task_manager.exceptions.NotFoundException;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface SkillService {
    SkillFullDto addNewSkill(SkillCreateDto createDto, long maderId) throws AlreadyExists;

    Page<SkillFullDto> getAllSkil(Integer from, Integer size, long maderId);

    SkillFullDto getSkilById(Long id, long maderId) throws NotFoundException;
    Collection<Skill> findAllByIds(Collection<Long> ids);
}
