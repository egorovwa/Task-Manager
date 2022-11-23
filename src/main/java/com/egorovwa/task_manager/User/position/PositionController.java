package com.egorovwa.task_manager.User.position;

import com.egorovwa.task_manager.dto.position.PositionCreateDto;
import com.egorovwa.task_manager.dto.position.PositionFullDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/position")
public class PositionController {
    private final PositionService service;

    @PostMapping
    public PositionFullDto createPosition(@Validated @RequestBody PositionCreateDto createDto){
        return service.createPosition(createDto);
    }
    @GetMapping
    public Page<PositionFullDto> findAllPosition(
            @RequestParam(value = "from", defaultValue = "0") Integer from,
            @RequestParam(value = "size", defaultValue = "10") Integer size){
        return service.findAll(from, size);
    }
}
