package com.egorovwa.task_manager.dto.skills;

import com.egorovwa.task_manager.model.SkillDoc;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link SkillDoc} entity
 */
@Data
public class SkillDocFullDto implements Serializable {
    private final String resLink;
    private final Long ownerId;
    private final Long skillId;
}