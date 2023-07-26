package com.genesisconsult.usecase.companycontacts.core.exception;

public class InvalidEntityException extends RuntimeException {
    public InvalidEntityException(String message) {
        super(message);
    }
}