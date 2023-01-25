package com.egorovwa.task_manager.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserShortDto {
    private Long userId;
    private String surname;
    private String name;
    private String positionName;
}
