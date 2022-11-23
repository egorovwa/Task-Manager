package com.egorovwa.task_manager.dto.position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionShortDto {
    private Long id;
    private String title;
    private String description;
}
