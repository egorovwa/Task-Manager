package com.egorovwa.task_manager.User.position;

import com.egorovwa.task_manager.User.model.Position;
import com.egorovwa.task_manager.User.skillss.SkilllDtoMaper;
import com.egorovwa.task_manager.dto.position.PositionFullDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PositionDtoMaper {
public static PositionFullDto toFullDto(Position position){
    return new PositionFullDto(position.getId(),
            position.getTitle(),
            position.getDescription(),
            position.getAccess().toString(),
            position.getMustBeSkills().stream().map(SkilllDtoMaper::toShortDto).collect(Collectors.toList()));
}
}
