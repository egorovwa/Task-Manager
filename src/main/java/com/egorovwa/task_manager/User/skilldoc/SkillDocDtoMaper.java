package com.egorovwa.task_manager.User.skilldoc;

import com.egorovwa.task_manager.dto.skills.SkillDocFullDto;
import com.egorovwa.task_manager.model.SkillDoc;

public class SkillDocDtoMaper {
    public static SkillDoc fromFullDto(SkillDocFullDto fullDto){
        return new SkillDoc(fullDto.getResLink(), fullDto.getOwnerId(), fullDto.getSkillId());
    }
}
