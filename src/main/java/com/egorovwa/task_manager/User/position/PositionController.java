package com.egorovwa.task_manager.User.position;

import com.egorovwa.task_manager.Utils;
import com.egorovwa.task_manager.dto.position.PositionCreateDto;
import com.egorovwa.task_manager.dto.position.PositionFullDto;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import com.egorovwa.task_manager.exceptions.IncorrectPageValueException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import static com.egorovwa.task_manager.Constats.MADER_ID_HEAD;

@RestController
@RequiredArgsConstructor
@RequestMapping("/position")
public class PositionController {
    private final PositionService service;

    @PostMapping
    public PositionFullDto createPosition(
            @Validated @RequestBody PositionCreateDto createDto,
            @RequestHeader(MADER_ID_HEAD) Long maderId
            ) throws AlreadyExists {
        return service.createPosition(createDto, maderId);
    }
    @GetMapping
    public Page<PositionFullDto> findAllPosition(
            @RequestParam(value = "from", defaultValue = "0") Integer from,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestHeader(MADER_ID_HEAD) Long maderId) throws IncorrectPageValueException {
        return service.findAll(Utils.createPageable(from, size), maderId);
    }
}
