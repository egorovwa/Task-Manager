package com.egorovwa.task_manager.exceptions;

public class NotFoundException extends Exception{

    public NotFoundException(String message, String className, String param, String value) {
        super(message);
    }
}
