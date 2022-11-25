package com.egorovwa.task_manager;

import com.egorovwa.task_manager.model.Access;
import com.egorovwa.task_manager.model.Position;

public class Constats {
    public static final String MADER_ID_HEAD = "mader_id";
    public static final Position FREE = new  Position(1L,
            "FREE","", Access.FREE,null, false); // TODO: 25.11.2022 добавить константы в бд
    public static final Long FREE_POSITION_ID = 1L;
    public static final String FREE_POSITION_ID_STRING = "1";
}
