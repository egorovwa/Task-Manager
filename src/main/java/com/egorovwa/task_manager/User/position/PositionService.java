package com.egorovwa.task_manager.User.position;

import com.egorovwa.task_manager.model.Position;
import com.egorovwa.task_manager.dto.position.PositionCreateDto;
import com.egorovwa.task_manager.dto.position.PositionFullDto;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PositionService {
    PositionFullDto createPosition(PositionCreateDto createDto, Long maderId) throws AlreadyExists;

    Page<PositionFullDto> findAll(Pageable pageable, Long maderId);
    Optional<Position> findById(Long id);
}
