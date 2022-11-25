package com.egorovwa.task_manager.dto.user;

import com.egorovwa.task_manager.model.SkillDoc;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Collection;

@Data
public class UserCreateDto {
    @NotBlank
    private String surname;
    @NotBlank
    private String name;
    @NotBlank
    private String identificationСard;
    @NotNull
    private Long positionId;
    private Collection<Long> skills;
    private Collection<SkillDoc> documentSkil;
    private Long deportamentIds;
}
