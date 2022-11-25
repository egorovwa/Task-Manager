package com.egorovwa.task_manager.User;

import com.egorovwa.task_manager.dto.user.UserCreateDto;
import com.egorovwa.task_manager.dto.user.UserFullDto;
import com.egorovwa.task_manager.exceptions.PositionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.egorovwa.task_manager.Constats.MADER_ID_HEAD;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @PostMapping
    public UserFullDto createUser(
            @RequestHeader(MADER_ID_HEAD) Long maderId,
            @Validated @RequestBody UserCreateDto createDto
    ) throws PositionNotFoundException {
        return service.createUser(maderId, createDto);
    }


}
