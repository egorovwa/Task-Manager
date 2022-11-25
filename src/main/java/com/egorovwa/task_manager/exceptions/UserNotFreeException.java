package com.egorovwa.task_manager.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserNotFreeException extends Exception{
    private UUID userId;

    public UserNotFreeException(String message, UUID userId) {
        super(message);
        this.userId = userId;
    }
}
