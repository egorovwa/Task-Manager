package com.egorovwa.task_manager.exceptions;

public class AlreadyExists extends NotFoundException{

    public AlreadyExists(String message, String className, String param, String value) {
        super(message, className, param, value);
    }

}
