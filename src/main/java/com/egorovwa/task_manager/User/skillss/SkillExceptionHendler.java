package com.egorovwa.task_manager.User.skillss;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.egorovwa.task_manager.User.skillss")
@Slf4j
public class SkillExceptionHendler {
@ExceptionHandler(Exception.class)
    public void exceptionHendle(Exception e){
    log.error(e.getMessage().toString());
}
}
