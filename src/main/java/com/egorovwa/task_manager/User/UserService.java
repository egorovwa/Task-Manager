package com.egorovwa.task_manager.User;

import com.egorovwa.task_manager.dto.user.UserCreateDto;
import com.egorovwa.task_manager.dto.user.UserFullDto;
import com.egorovwa.task_manager.exceptions.PositionNotFoundException;

public interface UserService {
    UserFullDto createUser(Long maderId, UserCreateDto createDto) throws PositionNotFoundException;
}
