package com.egorovwa.task_manager.department;

import com.egorovwa.task_manager.dto.deportament.DeportamenCreateDto;
import com.egorovwa.task_manager.dto.deportament.DeportamentFulldto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.egorovwa.task_manager.Constats.MADER_ID_HEAD;

@RestController
@RequiredArgsConstructor
@RequestMapping("/deportament")
public class DeportamentController {
    private final DeportamentService service;
    @PostMapping
    public DeportamentFulldto createDeportament(
            @RequestHeader(MADER_ID_HEAD) Long maderId,
            @RequestBody DeportamenCreateDto createDto
            ){
        return service.createDepotrament(maderId, createDto);
    }

}
