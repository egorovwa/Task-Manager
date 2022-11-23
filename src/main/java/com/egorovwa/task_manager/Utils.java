package com.egorovwa.task_manager;

import com.egorovwa.task_manager.User.model.Access;

public class Utils {
    public static Access fromStrind(String accessString) {
        return Access.valueOf(accessString);
    }
}
