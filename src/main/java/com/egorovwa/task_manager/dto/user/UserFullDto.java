package com.egorovwa.task_manager.dto.user;

import com.egorovwa.task_manager.User.model.Position;
import com.egorovwa.task_manager.User.model.SkillDoc;
import com.egorovwa.task_manager.User.skillss.Skill;
import com.egorovwa.task_manager.dto.skills.SkillShortDto;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Collection;
import java.util.UUID;

public class UserFullDto { // TODO: 24.11.2022 Вероятно изменить
    private UUID uuid;
    private String surname;
    private String name;
    private Position position;
    private Collection<SkillShortDto> skills;
}
