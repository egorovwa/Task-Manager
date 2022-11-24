package com.egorovwa.task_manager.User.position;

import com.egorovwa.task_manager.model.Position;
import com.egorovwa.task_manager.User.skillss.SkillService;
import com.egorovwa.task_manager.Utils;
import com.egorovwa.task_manager.dto.position.PositionCreateDto;
import com.egorovwa.task_manager.dto.position.PositionFullDto;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PositionServiceImpl implements PositionService {
    private final PositionRepository repository;
    private final SkillService skillService;

    @Override
    public PositionFullDto createPosition(PositionCreateDto createDto, Long maderId) throws AlreadyExists {
        log.info("User id = {} create position name = {}", maderId, createDto.getTitle());
        try {
            return PositionDtoMaper.toFullDto(repository.save(new Position(null, createDto.getTitle(),
                    createDto.getDescription(),
                    Utils.fromStrind(createDto.getAccess()),
                    skillService.findAllByIds(createDto.getMustBeSkills()) // TODO: 23.11.2022 if id not found hendle
            )));
        } catch (DataIntegrityViolationException e) {
            log.debug("User id = {}.  An attempt to create a position called {}", maderId, createDto.getTitle());
            throw new AlreadyExists("Position all redy exist.", "Position", "title", createDto.getTitle());
        }

    }

    @Override
    public Page<PositionFullDto> findAll(Pageable pageable, Long maderId) {
        log.debug("User id = {}. Requested all Position", maderId);
        return repository.findAll(pageable).map(PositionDtoMaper::toFullDto);
    }

    @Override
    public Optional<Position> findById(Long id) {
        return repository.findById(id);
    }
}
