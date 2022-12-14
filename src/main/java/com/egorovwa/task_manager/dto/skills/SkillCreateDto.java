package com.egorovwa.task_manager.dto.skills;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SkillCreateDto {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Boolean isRequiresConfirmation;
}
