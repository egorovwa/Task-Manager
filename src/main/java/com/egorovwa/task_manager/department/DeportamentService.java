package com.egorovwa.task_manager.department;

import com.egorovwa.task_manager.dto.deportament.DeportamenCreateDto;
import com.egorovwa.task_manager.dto.deportament.DeportamentFulldto;
import com.egorovwa.task_manager.model.Deportament;

public interface DeportamentService {
    Deportament findById(Long r);

    DeportamentFulldto createDepotrament(Long maderId, DeportamenCreateDto createDto);
}
