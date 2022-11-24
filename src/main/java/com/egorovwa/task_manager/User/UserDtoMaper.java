package com.egorovwa.task_manager.User;

import com.egorovwa.task_manager.User.position.PositionDtoMaper;
import com.egorovwa.task_manager.User.skillss.SkilllDtoMaper;
import com.egorovwa.task_manager.dto.user.UserFullDto;
import com.egorovwa.task_manager.dto.user.UserShortDto;
import com.egorovwa.task_manager.model.User;

import java.util.stream.Collectors;

public class UserDtoMaper {
    public static UserFullDto toFullDto(User user) {
        return new UserFullDto(
                user.getUuid(),
                user.getSurname(),
                user.getName(),
                PositionDtoMaper.toShortDto(user.getPosition()),
                user.getSkills().stream().map(SkilllDtoMaper::toShortDto).collect(Collectors.toList()));
    }

    public static UserShortDto toShortDto(User user) {
        return new UserShortDto(user.getUuid(), user.getSurname(), user.getName(), user.getPosition().getTitle());
    }
}
