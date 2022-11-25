package com.egorovwa.task_manager.department;

import com.egorovwa.task_manager.dto.deportament.DeportamenCreateDto;
import com.egorovwa.task_manager.dto.deportament.DeportamentFulldto;
import com.egorovwa.task_manager.exceptions.*;
import com.egorovwa.task_manager.model.Deportament;

import java.util.Optional;
import java.util.UUID;

public interface DeportamentService {
    DeportamentFulldto findById(Long r, UUID maderId) throws DeportamentNotFoundException;

    DeportamentFulldto createDepotrament(UUID maderId, DeportamenCreateDto createDto) throws PositionNotFoundException, UserNotFoundException, AlreadyExists;

    void addStaf(UUID maderId, Long deportamentId, UUID userId) throws DeportamentNotFoundException, UserNotFoundException, NoActionRequired;

    void chengeDirector(UUID maderId, Long deportamentId, UUID userId);
    Optional<Deportament> findByIdOptional(Long id);
}
