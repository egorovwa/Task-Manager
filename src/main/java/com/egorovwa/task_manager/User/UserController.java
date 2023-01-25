package com.egorovwa.task_manager.User;

import com.egorovwa.task_manager.dto.skills.SkillDocFullDto;
import com.egorovwa.task_manager.dto.user.UserCreateDto;
import com.egorovwa.task_manager.dto.user.UserFullDto;
import com.egorovwa.task_manager.exceptions.*;
import com.egorovwa.task_manager.model.SkillDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

import static com.egorovwa.task_manager.Constats.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService service;


    @PostMapping
    public UserFullDto createUser(
            @RequestHeader(MADER_ID_HEAD) UUID maderId,
            @Validated @RequestBody UserCreateDto createDto
    ) throws PositionNotFoundException, DeportamentNotFoundException, AlreadyExists {
        return service.createUser(maderId, createDto);
    }

    @PutMapping("/{userId}/position")
    public UserFullDto putOnPosition(
            @RequestHeader(MADER_ID_HEAD) UUID maderId,
            @PathVariable("userId") UUID userId,
            @RequestParam(value = "positionId", defaultValue = FREE_POSITION_ID_STRING) Long positionId
    ) throws UserNotFoundException, IllegalActionException, PositionNotFoundException {
        return service.putUserToPosition(maderId, userId, positionId);
    }

    @PutMapping("/{userId}/skill")
    public UserFullDto addScill(
            @RequestHeader(MADER_ID_HEAD) UUID maderId,
            @PathVariable("userId") UUID userId,
            @RequestParam("skillId") Long skillId,
            @Validated @RequestBody SkillDocFullDto skillDoc
    ) throws NotFoundException, SkillRequiresConfirmationException {
        Optional<SkillDocFullDto> mayBeSkillDoc = Optional.ofNullable(skillDoc);
        return service.addSkill(maderId, userId, skillId, mayBeSkillDoc);
    }

}
