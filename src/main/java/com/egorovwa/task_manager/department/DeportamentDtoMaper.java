package com.egorovwa.task_manager.department;

import com.egorovwa.task_manager.User.UserDtoMaper;
import com.egorovwa.task_manager.dto.deportament.DeportamentFulldto;
import com.egorovwa.task_manager.dto.deportament.DeportamentShortDto;
import com.egorovwa.task_manager.model.Deportament;

import java.util.stream.Collectors;

public class DeportamentDtoMaper {
    public static DeportamentFulldto toFullDto(Deportament deportament){
        return new DeportamentFulldto(
                deportament.getId(),
                deportament.getName(),
                UserDtoMaper.toShortDto(deportament.getDirector()),
                deportament.getSubordinateDepartments().stream().map(DeportamentDtoMaper::toShortDto).collect(Collectors.toList()),
                deportament.getStaff().stream().map(UserDtoMaper::toShortDto).collect(Collectors.toList())
                );
    }
    public static DeportamentShortDto toShortDto(Deportament deportament){
        return new DeportamentShortDto(deportament.getId(), deportament.getName());
    }
}
