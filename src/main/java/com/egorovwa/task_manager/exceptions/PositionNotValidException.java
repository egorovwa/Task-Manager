package com.egorovwa.task_manager.exceptions;

import com.egorovwa.task_manager.model.Position;
import lombok.Getter;

@Getter
public class PositionNotValidException extends Exception{
    Position position;

    public PositionNotValidException(String message, Position position) {
        super(message);
        this.position = position;
    }
}
