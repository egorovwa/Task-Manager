package com.egorovwa.task_manager.User.skillss;

import com.egorovwa.task_manager.dto.skills.SkillCreateDto;
import com.egorovwa.task_manager.dto.skills.SkillFullDto;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import com.egorovwa.task_manager.exceptions.NotFoundException;
import com.egorovwa.task_manager.model.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.UUID;

public interface SkillService {
    SkillFullDto addNewSkill(SkillCreateDto createDto, Long maderId) throws AlreadyExists;

    Page<SkillFullDto> getAllSkil(Pageable pageable, Long maderId);

    SkillFullDto getSkilById(Long id, Long maderId) throws NotFoundException;

    Skill getSkilById(Long id) throws NotFoundException;

    Collection<Skill> findAllByIds(Collection<Long> ids);
}
