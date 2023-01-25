package com.egorovwa.task_manager.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserNotFreeException extends Exception{
    private Long userId;

    public UserNotFreeException(String message, Long userId) {
        super(message);
        this.userId = userId;
    }
}
