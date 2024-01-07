package com.santex.santex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SantexExceptionNotFound extends RuntimeException {

    public SantexExceptionNotFound(String message) {
        super(message);
    }
}
