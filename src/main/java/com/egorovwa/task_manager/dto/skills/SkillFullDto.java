package com.egorovwa.task_manager.dto.skills;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillFullDto {
    private Long id;
    private String title;
    private String description;
    private Boolean isRequiresConfirmation;
}
