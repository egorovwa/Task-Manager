package com.egorovwa.task_manager.exceptions;

public class UserNotFoundException extends NotFoundException{
    public UserNotFoundException(String param, String value) {
        super("User %s = %s notFound", "User", param, value);
    }
}
