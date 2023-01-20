package com.egorovwa.task_manager.exceptions;

public class SkillNotFoundException extends NotFoundException{
    public SkillNotFoundException(String param, String value) {
        super(String.format("Skill %s = %s not found.", param, value), "Skill", param, value);
    }
}
