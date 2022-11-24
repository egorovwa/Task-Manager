package com.egorovwa.task_manager.dto.user;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserCreateDto {
    @NotBlank
    private String surname;
    @NotBlank
    private String name;
}
