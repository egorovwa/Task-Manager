package com.egorovwa.task_manager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConControl {
    @GetMapping("/")
    public String getResponse(){
        return "DA DA DA;";
    }
}
