package com.egorovwa.task_manager.dto.deportament;

import com.egorovwa.task_manager.model.Position;
import com.egorovwa.task_manager.model.User;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeportamenCreateDto {
    @NotBlank
    private String name;
    @NonNull
    private Long directorPositionId;
    @NotNull
    private UUID directorId;
}
