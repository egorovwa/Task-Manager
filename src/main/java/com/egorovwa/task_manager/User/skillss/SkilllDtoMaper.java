package com.egorovwa.task_manager.User.skillss;

import com.egorovwa.task_manager.User.skillss.Skill;
import com.egorovwa.task_manager.dto.skills.SkillCreateDto;
import com.egorovwa.task_manager.dto.skills.SkillFullDto;
import com.egorovwa.task_manager.dto.skills.SkillShortDto;

public class SkilllDtoMaper {
    public static Skill fromCreateDto(SkillCreateDto dto) {
        return new Skill(null, dto.getTitle(), dto.getDescription(), dto.getIsRequiresConfirmation());
    }
    public static SkillFullDto toDtoFulDto(Skill skill){
        return new SkillFullDto(skill.getId(), skill.getTitle(),skill.getDescription(),skill.getIsRequiresConfirmation());
    }
    public static SkillShortDto toShortDto(Skill skill){
        return new SkillShortDto(skill.getId(), skill.getTitle());
    }
}
