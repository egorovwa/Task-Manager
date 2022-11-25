package com.egorovwa.task_manager.User;

import com.egorovwa.task_manager.dto.user.UserCreateDto;
import com.egorovwa.task_manager.dto.user.UserFullDto;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import com.egorovwa.task_manager.exceptions.DeportamentNotFoundException;
import com.egorovwa.task_manager.exceptions.PositionNotFoundException;
import com.egorovwa.task_manager.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserFullDto createUser(Long maderId, UserCreateDto createDto) throws PositionNotFoundException, AlreadyExists, DeportamentNotFoundException;
    Optional<User> findByIdOptional(UUID id);

    void updateUser(User user);
}
