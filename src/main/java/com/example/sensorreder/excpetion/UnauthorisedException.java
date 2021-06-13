package com.example.allianhw.excpetion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorisedException extends Exception {
    public UnauthorisedException(String message) {
        super(message);
    }
}
