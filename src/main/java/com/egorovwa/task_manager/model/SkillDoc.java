package com.egorovwa.task_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SkillDoc {
    @Id
    @Column(unique = true)
    private String resLink;
    private Long ownerId;
    private Long skillId;

}
