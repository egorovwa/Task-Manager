package com.egorovwa.task_manager.User;

import com.egorovwa.task_manager.department.DeportamentService;
import com.egorovwa.task_manager.model.Deportament;
import com.egorovwa.task_manager.model.Position;
import com.egorovwa.task_manager.model.User;
import com.egorovwa.task_manager.User.position.PositionService;
import com.egorovwa.task_manager.User.skillss.Skill;
import com.egorovwa.task_manager.User.skillss.SkillService;
import com.egorovwa.task_manager.dto.user.UserCreateDto;
import com.egorovwa.task_manager.dto.user.UserFullDto;
import com.egorovwa.task_manager.exceptions.PositionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PositionService positionService;
    private final SkillService skillService;
    private final DeportamentService deportamentService;
    @Override
    public UserFullDto createUser(Long maderId, UserCreateDto createDto) throws PositionNotFoundException {
        Position position = positionService.findById(createDto.getPositionId())
                .orElseThrow(()-> new PositionNotFoundException("id", createDto.getPositionId().toString()));
        Collection<Skill> skills = skillService.findAllByIds(createDto.getSkills());
        Collection<Deportament> deportaments = createDto.getDeportamentIds()
                .stream().map(r -> deportamentService.findById(r)).toList(); // TODO: 24.11.2022 exceptions

        return UserDtoMaper.toFullDto(new User(
                UUID.randomUUID(),          // TODO: 24.11.2022 может в конструктор класса
                createDto.getSurname(),
                createDto.getName(),
                createDto.getIdentificationСard(),
                position,
                skills,
                createDto.getDocumentSkil(),
                deportaments
        ));
    }
}
