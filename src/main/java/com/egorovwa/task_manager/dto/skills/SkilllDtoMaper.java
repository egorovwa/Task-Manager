package com.egorovwa.task_manager.dto.skills;

import com.egorovwa.task_manager.User.skillss.Skill;

public class SkilllDtoMaper {
    public static Skill fromCreateDto(SkillCreateDto dto) {
        return new Skill(null, dto.getTitle(), dto.getDescription(), dto.getIsRequiresConfirmation());
    }
    public static SkillFullDto toDtoFulDto(Skill skill){
        return new SkillFullDto(skill.getId(), skill.getTitle(),skill.getDescription(),skill.getIsRequiresConfirmation());
    }
}
