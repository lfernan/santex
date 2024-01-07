package com.santex.santex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class SantexExceptionInternalServer extends RuntimeException {
    public SantexExceptionInternalServer(String message) {
        super(message);
    }
}
