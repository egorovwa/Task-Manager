package com.egorovwa.task_manager.User.skillss;

import com.egorovwa.task_manager.dto.skills.SkillCreateDto;
import com.egorovwa.task_manager.dto.skills.SkillFullDto;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import com.egorovwa.task_manager.exceptions.NotFoundException;
import com.egorovwa.task_manager.exceptions.SkillNotFoundException;
import com.egorovwa.task_manager.model.Skill;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SkillServiceImpl implements SkillService {
    private final SkillRepository repository;
    @Override
    @Transactional
    public SkillFullDto addNewSkill(SkillCreateDto createDto, UUID maderId) throws AlreadyExists {
log.info("User id ={}. Creared new skill with title {}.", maderId, createDto.getTitle());
        try {
            return SkilllDtoMaper.toDtoFulDto(repository.save(SkilllDtoMaper.fromCreateDto(createDto)));
        } catch (DataIntegrityViolationException e) {
            log.info("User id = {}. An attempt to create a skill called {}", maderId, createDto.getTitle());
            throw new AlreadyExists("Skil", "Slill", "title", createDto.getTitle());
        }
    }

    @Override
    public Page<SkillFullDto> getAllSkil(Pageable pageable, UUID maderId) {
        log.debug("User id ={}, requested all Skils", maderId);
        return repository.findAll(pageable).map(SkilllDtoMaper::toDtoFulDto);
    }

    @Override
    public SkillFullDto getSkilById(Long id, UUID maderId) throws NotFoundException {
        log.debug("User id = {}, requested Skill id = {}", maderId, id);
        return SkilllDtoMaper.toDtoFulDto(repository.findById(id)
                .orElseThrow(()-> new  NotFoundException("Skill", "id", id.toString(),"Not found "))); // TODO: 23.11.2022 afte exception hende

    }
    @Override
    public Skill getSkilById(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(()->new SkillNotFoundException("id", id.toString()));
    }

    @Override
    public Collection<Skill> findAllByIds(Collection<Long> ids) {
        return repository.findAllById(ids);
    }
}
