package com.egorovwa.task_manager.exceptions;

public class DeportamentNotFoundException extends NotFoundException{
    public DeportamentNotFoundException( String param, String value) {
        super(String.format("Deportament %s = %s not found", param, value), "Deportament", param, value);
    }
}
