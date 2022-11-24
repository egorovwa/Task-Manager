package com.egorovwa.task_manager.User;

import com.egorovwa.task_manager.dto.user.UserCreateDto;
import com.egorovwa.task_manager.dto.user.UserFullDto;

public interface UserService {
    UserFullDto createUser(Long maderId, UserCreateDto createDto);
}
