package com.egorovwa.task_manager.User.skillss;

import com.egorovwa.task_manager.dto.skills.SkillCreateDto;
import com.egorovwa.task_manager.dto.skills.SkillFullDto;
import com.egorovwa.task_manager.dto.skills.SkilllDtoMaper;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import com.egorovwa.task_manager.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository repository;
    @Override
    public SkillFullDto addNewSkill(SkillCreateDto createDto) throws AlreadyExists {

        try {
            return SkilllDtoMaper.toDtoFulDto(repository.save(SkilllDtoMaper.fromCreateDto(createDto)));
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExists("Skil", "Slill", "title", createDto.getTitle());
        }
    }

    @Override
    public Page<SkillFullDto> getAllSkil(Integer from, Integer size) {
        return repository.findAll(from, size).map(SkilllDtoMaper::toDtoFulDto);
    }

    @Override
    public SkillFullDto getSkilById(Long id) throws NotFoundException {
        return SkilllDtoMaper.toDtoFulDto(repository.findById(id)
                .orElseThrow(()-> new  NotFoundException("Skill", "id", id.toString(),"Not found "))); // TODO: 23.11.2022 afte exception hende

    }
}
