package com.egorovwa.task_manager.exceptions;

import java.util.UUID;

public class SkillRequiresConfirmationException extends Exception{
    UUID userId;
    Long skillId;

    public SkillRequiresConfirmationException(UUID userId, Long skillId) {
        super(String.format("Skill id = %s for user id = %s requires a supporting document", skillId, userId));
        this.userId = userId;
        this.skillId = skillId;
    }
}
