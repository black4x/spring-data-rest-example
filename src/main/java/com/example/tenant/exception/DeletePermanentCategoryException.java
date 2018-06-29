package com.example.tenant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DeletePermanentCategoryException extends RuntimeException {

    public DeletePermanentCategoryException() {
        super("permanent category can not be deleted.");
    }
}
