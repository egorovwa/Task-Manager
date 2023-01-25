package com.egorovwa.task_manager.User;

import com.egorovwa.task_manager.dto.skills.SkillDocFullDto;
import com.egorovwa.task_manager.dto.user.UserCreateDto;
import com.egorovwa.task_manager.dto.user.UserFullDto;
import com.egorovwa.task_manager.exceptions.*;
import com.egorovwa.task_manager.model.SkillDoc;
import com.egorovwa.task_manager.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserFullDto createUser(UUID maderId, UserCreateDto createDto) throws PositionNotFoundException, AlreadyExists, DeportamentNotFoundException;

    void updateUser(User user);

    UserFullDto putUserToPosition(UUID maderId, UUID userId, Long positionId) throws UserNotFoundException, PositionNotFoundException, IllegalActionException;

    UserFullDto addSkill(UUID maderId, UUID userId, Long skillId, Optional<SkillDocFullDto> mayBeSkillDoc) throws NotFoundException, SkillRequiresConfirmationException;
}
