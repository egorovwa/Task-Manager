package com.egorovwa.task_manager.dto.user;

import com.egorovwa.task_manager.dto.position.PositionShortDto;
import com.egorovwa.task_manager.dto.skills.SkillShortDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFullDto { // TODO: 24.11.2022 Вероятно изменить
    private UUID uuid;
    private String surname;
    private String name;
    private PositionShortDto position;
    private Collection<SkillShortDto> skills;
}
