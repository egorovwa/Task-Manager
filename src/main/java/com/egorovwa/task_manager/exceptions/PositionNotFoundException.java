package com.egorovwa.task_manager.exceptions;

public class PositionNotFoundException extends NotFoundException{
    public PositionNotFoundException(String param, String value) {
        super(String.format("Psition %s = %s not found",param, value), "Position", param, value);
    }
}
