package com.egorovwa.task_manager.User.position;

import com.egorovwa.task_manager.User.model.Position;
import com.egorovwa.task_manager.User.skillss.SkillService;
import com.egorovwa.task_manager.Utils;
import com.egorovwa.task_manager.dto.position.PositionCreateDto;
import com.egorovwa.task_manager.dto.position.PositionFullDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PositionServiceImpl implements PositionService {
    private final PositionRepository repository;
    private final SkillService skillService;

    @Override
    public PositionFullDto createPosition(PositionCreateDto createDto) {
log.info("Position {} created ");
        return PositionDtoMaper.toFullDto(repository.save(new Position(null, createDto.getTitle(),
                createDto.getDescription(),
                Utils.fromStrind(createDto.getAccess()),
                skillService.findAllByIds(createDto.getMustBeSkills()) // TODO: 23.11.2022 if id not found hendle
        )));

    }

    @Override
    public Page<PositionFullDto> findAll(Integer from, Integer size) {
        return repository.findAll(from, size);
    }
}
