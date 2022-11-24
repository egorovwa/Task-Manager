package com.egorovwa.task_manager.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserShortDto {
    private UUID uuid;
    private String surname;
    private String name;
    private String positionName;
}
