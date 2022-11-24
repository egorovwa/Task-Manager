package com.egorovwa.task_manager.dto.position;

import com.egorovwa.task_manager.dto.skills.SkillShortDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionFullDto {
    private Long id;
    private String title;
    private String description;
    private String access;
    private Collection<SkillShortDto> mustBeSkills;
}
