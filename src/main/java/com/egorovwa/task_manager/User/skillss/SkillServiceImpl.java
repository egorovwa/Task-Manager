package com.egorovwa.task_manager.User.skillss;

import com.egorovwa.task_manager.dto.skills.SkillCreateDto;
import com.egorovwa.task_manager.dto.skills.SkillFullDto;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import com.egorovwa.task_manager.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class SkillServiceImpl implements SkillService {
    private final SkillRepository repository;
    @Override
    @Transactional
    public SkillFullDto addNewSkill(SkillCreateDto createDto, long maderId) throws AlreadyExists {
log.info("User id ={}. Creared new skill with title {}.", maderId, createDto.getTitle());
        try {
            return SkilllDtoMaper.toDtoFulDto(repository.save(SkilllDtoMaper.fromCreateDto(createDto)));
        } catch (DataIntegrityViolationException e) {
            log.info("User id = {}. An attempt to create a skill called {}", maderId, createDto.getTitle());
            throw new AlreadyExists("Skil", "Slill", "title", createDto.getTitle());
        }
    }

    @Override
    public Page<SkillFullDto> getAllSkil(Integer from, Integer size, long maderId) {
        log.debug("User id ={}, requested all Skils", maderId);
        return repository.findAll(from, size).map(SkilllDtoMaper::toDtoFulDto);
    }

    @Override
    public SkillFullDto getSkilById(Long id, long maderId) throws NotFoundException {
        log.debug("User id = {}, requested Skill id = {}", maderId, id);
        return SkilllDtoMaper.toDtoFulDto(repository.findById(id)
                .orElseThrow(()-> new  NotFoundException("Skill", "id", id.toString(),"Not found "))); // TODO: 23.11.2022 afte exception hende

    }

    @Override
    public Collection<Skill> findAllByIds(Collection<Long> ids) {
        return repository.findAllById(ids);
    }
}
