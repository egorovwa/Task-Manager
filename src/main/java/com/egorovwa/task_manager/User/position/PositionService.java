package com.egorovwa.task_manager.User.position;

import com.egorovwa.task_manager.dto.position.PositionCreateDto;
import com.egorovwa.task_manager.dto.position.PositionFullDto;
import org.springframework.data.domain.Page;

public interface PositionService {
    PositionFullDto createPosition(PositionCreateDto createDto);

    Page<PositionFullDto> findAll(Integer from, Integer size);
}
