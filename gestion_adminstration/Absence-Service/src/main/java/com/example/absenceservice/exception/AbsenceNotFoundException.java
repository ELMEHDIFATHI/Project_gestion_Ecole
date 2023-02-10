package com.example.absenceservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AbsenceNotFoundException extends RuntimeException {
    public AbsenceNotFoundException(Long id) {
        super("Could not find absence with id " + id);
    }

}
