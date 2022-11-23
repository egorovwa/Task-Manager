package com.egorovwa.task_manager.User.skillss;

import com.egorovwa.task_manager.dto.skills.SkillCreateDto;
import com.egorovwa.task_manager.dto.skills.SkillFullDto;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import com.egorovwa.task_manager.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/skill")
public class SkillController {
    private final SkillService service;

    @PostMapping
    public SkillFullDto createSkill(
            @Validated @RequestBody SkillCreateDto createDto,
            @RequestHeader("x-User-id") long userId
            ) throws AlreadyExists {
        return service.addNewSkill(createDto, userId);
    }
    @GetMapping
    public Page<SkillFullDto> getAllSkills(
            @RequestHeader("x-User-id") long maderId,
            @RequestParam(value = "from", defaultValue = "0") Integer from,
            @RequestParam(value = "size", defaultValue = "20") Integer size){
        return service.getAllSkil(from, size, maderId);
    }
    @GetMapping("/{id}")
    public SkillFullDto getSkillById(
            @PathVariable("id") Long id,
            @RequestHeader("x-User-id") long maderId
    ) throws NotFoundException {
        return service.getSkilById(id, maderId);
    }
}
