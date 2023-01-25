package com.egorovwa.task_manager.User;

import com.egorovwa.task_manager.User.position.PositionService;
import com.egorovwa.task_manager.User.skilldoc.SkillDocDtoMaper;
import com.egorovwa.task_manager.User.skilldoc.SkillDocService;
import com.egorovwa.task_manager.User.skillss.SkillService;
import com.egorovwa.task_manager.department.DeportamentService;
import com.egorovwa.task_manager.dto.skills.SkillDocFullDto;
import com.egorovwa.task_manager.dto.user.UserCreateDto;
import com.egorovwa.task_manager.dto.user.UserFullDto;
import com.egorovwa.task_manager.exceptions.*;
import com.egorovwa.task_manager.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.egorovwa.task_manager.Constats.FREE_POSITION_ID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final PositionService positionService;
    private final SkillService skillService;
    private final DeportamentService deportamentService;
    private final UserRepository userRepository;
    private final SkillDocService skillDocService;

    @Override
    public UserFullDto createUser(UUID maderId, UserCreateDto createDto) throws PositionNotFoundException, AlreadyExists, DeportamentNotFoundException {
        Position position = positionService.findById(FREE_POSITION_ID)
                .orElseThrow(() -> new PositionNotFoundException("id", FREE_POSITION_ID.toString())); // TODO: 25.11.2022 Android - create_user fragment -> user_to-position fragment 
        Collection<Skill> skills = skillService.findAllByIds(createDto.getSkills()); // TODO: 25.11.2022 when error hendler create

        Deportament deportaments = deportamentService.findByIdOptional(createDto.getDeportamentIds())
                .orElseThrow(() -> new DeportamentNotFoundException("id", createDto.getDeportamentIds().toString()));

        log.info("User id = {}, add User name with {} {}", maderId, createDto.getName(), createDto.getSurname());

        try {
            return UserDtoMaper.toFullDto(userRepository.save(new User(
                    null,
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
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public UserFullDto putUserToPosition(UUID maderId, UUID userId, Long positionId) throws UserNotFoundException, PositionNotFoundException, IllegalActionException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("id", userId.toString()));
        Position position = positionService.findById(positionId)
                .orElseThrow(() -> new PositionNotFoundException("id", positionId.toString()));

        user.setPosition(position);
        userRepository.save(user);
        deportamentService.findByDirectorPosition(position)
                .ifPresent(r -> {
                    r.getDirector().setPosition(positionService.findById(FREE_POSITION_ID)
                            .orElseThrow());
                    r.setDirector(user);
                    deportamentService.updateDeportament(r);
                });

        return UserDtoMaper.toFullDto(user);
    }

    @Override
    public UserFullDto addSkill(UUID maderId, UUID userId, Long skillId, Optional<SkillDocFullDto> mayBeSkillDoc) throws NotFoundException, SkillRequiresConfirmationException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("id", userId.toString()));
        Skill skill = skillService.getSkilById(skillId);
        if (skill.getIsRequiresConfirmation()) {
            SkillDoc skillDoc = SkillDocDtoMaper.fromFullDto(mayBeSkillDoc
                    .orElseThrow(() -> new SkillRequiresConfirmationException(userId, skillId)));
            skillDocService.addSkilDoc(maderId, skillDoc);
        }
        user.getSkills().add(skill);
        return UserDtoMaper.toFullDto(userRepository.save(user));
    }
}
