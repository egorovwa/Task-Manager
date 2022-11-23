package com.egorovwa.task_manager.dto.position;

import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionCreateDto {
    @NotBlank
    private String title;
    @Size(min = 5, max = 3000)
    private String description;
    @NonNull
    private String access;
    private Collection<Integer> mustBeSkills;
}
