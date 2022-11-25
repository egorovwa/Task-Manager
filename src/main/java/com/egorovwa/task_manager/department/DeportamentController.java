package com.egorovwa.task_manager.department;

import com.egorovwa.task_manager.dto.deportament.DeportamenCreateDto;
import com.egorovwa.task_manager.dto.deportament.DeportamentFulldto;
import com.egorovwa.task_manager.exceptions.AlreadyExists;
import com.egorovwa.task_manager.exceptions.DeportamentNotFoundException;
import com.egorovwa.task_manager.exceptions.PositionNotFoundException;
import com.egorovwa.task_manager.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.egorovwa.task_manager.Constats.MADER_ID_HEAD;

@RestController
@RequiredArgsConstructor
@RequestMapping("/deportament")
public class DeportamentController {
    private final DeportamentService service;

    @PostMapping
    public DeportamentFulldto createDeportament(
            @RequestHeader(MADER_ID_HEAD) UUID maderId,
            @RequestBody DeportamenCreateDto createDto
    ) throws UserNotFoundException, PositionNotFoundException, AlreadyExists {
        return service.createDepotrament(maderId, createDto);
    }

    @PutMapping("/{deportamentId}/staff/{userId}")
    public void addStaff(
            @PathVariable("deportamentId") Long deportamentId,
            @PathVariable("userId") UUID userId,
            @RequestHeader(MADER_ID_HEAD) UUID maderId
    ) throws UserNotFoundException, DeportamentNotFoundException {
        service.addStaf(maderId, deportamentId, userId);
    }
    @PutMapping("/{deportamentId}/director/{userId}")
public void changeDirecto(
            @PathVariable("deportamentId") Long deportamentId,
            @PathVariable("userId") UUID userId,
            @RequestHeader(MADER_ID_HEAD) UUID maderId
    ){
        service.chengeDirector(maderId, deportamentId, userId);
    }
    @GetMapping("/{id}")
    public DeportamentFulldto findById(
            @RequestHeader(MADER_ID_HEAD) UUID maderId,
            @PathVariable("id") Long id
    ) throws DeportamentNotFoundException {
        return service.findById(id, maderId);
    }

}
