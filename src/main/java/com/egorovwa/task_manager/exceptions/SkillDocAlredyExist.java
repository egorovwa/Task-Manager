package com.egorovwa.task_manager.exceptions;

public class SkillDocAlredyExist extends AlreadyExists{
    public SkillDocAlredyExist(String param, String value) {
        super("Skill document from %s (%s) already exist", "SkillDoc", param, value);
    }
}
