package com.egorovwa.task_manager.exceptions;

import lombok.Getter;

import java.util.Map;
@Getter
public class IllegalActionException extends Exception{
    String action;
    Map<String,String> value;

    public IllegalActionException(String message, String action, Map<String, String> value) {
        super(message);
        this.action = action;
        this.value = value;
    }
}
