package com.egorovwa.task_manager.model;

import com.egorovwa.task_manager.User.skillss.Skill;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SkillDoc {
    @Id
    @Column(unique = true)
    private String resLink;
    private Long ownerId;
    private Long skillId;

}
