package com.egorovwa.task_manager.User;

import com.egorovwa.task_manager.User.position.PositionService;
import com.egorovwa.task_manager.User.skillss.Skill;
import com.egorovwa.task_manager.User.skillss.SkillService;
import com.egorovwa.task_manager.department.DeportamentService;
import com.egorovwa.task_manager.dto.user.UserCreateDto;
import com.egorovwa.task_manager.dto.user.UserFullDto;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import com.egorovwa.task_manager.exceptions.DeportamentNotFoundException;
import com.egorovwa.task_manager.exceptions.PositionNotFoundException;
import com.egorovwa.task_manager.model.Deportament;
import com.egorovwa.task_manager.model.Position;
import com.egorovwa.task_manager.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final PositionService positionService;
    private final SkillService skillService;
    private final DeportamentService deportamentService;
    private final UserRepository userRepository;

    @Override
    public UserFullDto createUser(Long maderId, UserCreateDto createDto) throws PositionNotFoundException, AlreadyExists, DeportamentNotFoundException {
        Position position = positionService.findById(createDto.getPositionId())
                .orElseThrow(() -> new PositionNotFoundException("id", createDto.getPositionId().toString()));
        Collection<Skill> skills = skillService.findAllByIds(createDto.getSkills()); // TODO: 25.11.2022 when error hendler create

        Deportament deportaments = deportamentService.findByIdOptional(createDto.getDeportamentIds())
                .orElseThrow(() -> new DeportamentNotFoundException("id", createDto.getDeportamentIds().toString()));

        log.info("User id = {}, add User name with {} {}", maderId, createDto.getName(), createDto.getSurname());

        try {
            return UserDtoMaper.toFullDto(userRepository.save(new User(
                    UUID.randomUUID(),          // TODO: 24.11.2022 может в конструктор класса
                    createDto.getSurname(),
                    createDto.getName(),
                    createDto.getIdentificationСard(),
                    position,
                    skills,
                    createDto.getDocumentSkil(),
                    deportaments
            )));
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExists("User with Inditification card {} alredy exist",
                    "User", "identificationСard", createDto.getIdentificationСard());
        }
    }

    @Override
    public Optional<User> findByIdOptional(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
