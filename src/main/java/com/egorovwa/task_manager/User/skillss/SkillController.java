package com.egorovwa.task_manager.User.skillss;

import com.egorovwa.task_manager.Utils;
import com.egorovwa.task_manager.dto.skills.SkillCreateDto;
import com.egorovwa.task_manager.dto.skills.SkillFullDto;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import com.egorovwa.task_manager.exceptions.IncorrectPageValueException;
import com.egorovwa.task_manager.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import static com.egorovwa.task_manager.Constats.MADER_ID_HEAD;

@RestController
@RequiredArgsConstructor
@RequestMapping("/skill")
public class SkillController {
    private final SkillService service;

    @PostMapping
    public SkillFullDto createSkill(
            @Validated @RequestBody SkillCreateDto createDto,
            @RequestHeader(MADER_ID_HEAD) long userId
            ) throws AlreadyExists {
        return service.addNewSkill(createDto, userId);
    }
    @GetMapping
    public Page<SkillFullDto> getAllSkills(
            @RequestHeader(MADER_ID_HEAD) long maderId,
            @RequestParam(value = "from", defaultValue = "0") Integer from,
            @RequestParam(value = "size", defaultValue = "20") Integer size) throws IncorrectPageValueException {
        return service.getAllSkil(Utils.createPageable(from, size), maderId);
    }
    @GetMapping("/{id}")
    public SkillFullDto getSkillById(
            @PathVariable("id") Long id,
            @RequestHeader(MADER_ID_HEAD) long maderId
    ) throws NotFoundException {
        return service.getSkilById(id, maderId);
    }
}
