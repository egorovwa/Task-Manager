package com.egorovwa.task_manager.dto.position;

import com.egorovwa.task_manager.User.model.Access;
import com.egorovwa.task_manager.User.skillss.Skill;
import com.egorovwa.task_manager.dto.skills.SkillShortDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
