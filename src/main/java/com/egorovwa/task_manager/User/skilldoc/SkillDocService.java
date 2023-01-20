package com.egorovwa.task_manager.User.skilldoc;

import com.egorovwa.task_manager.model.SkillDoc;

import java.util.UUID;

public interface SkillDocService {
    SkillDoc addSkilDoc(UUID maderId, SkillDoc skillDoc);
}
