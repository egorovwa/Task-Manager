package com.egorovwa.task_manager;

import com.egorovwa.task_manager.model.Access;
import com.egorovwa.task_manager.exceptions.IncorrectPageValueException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Utils {
    public static Access fromStrind(String accessString) {
        return Access.valueOf(accessString);
    }
    public static Pageable createPageable(Integer from, Integer size, String sortColumn) throws IncorrectPageValueException {
        if (from == null || size == null) {
            return null;
        } else {
            if (from < 0 || size <= 0) {
                throw new IncorrectPageValueException("Значения недолжныбыть менше 0");
            }
            Sort sort = Sort.by(sortColumn).descending();
            return PageRequest.of(from / size, size, sort);
        }
    }

    public static Pageable createPageable(Integer from, Integer size) throws IncorrectPageValueException {
        if (from == null || size == null) {
            return null;
        } else {
            if (from < 0 || size <= 0) {
                throw new IncorrectPageValueException("Значения недолжныбыть менше 0");
            }
            return PageRequest.of(from / size, size);
        }
    }
}
