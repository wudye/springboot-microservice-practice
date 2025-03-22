package com.mwu.corebankingservice.exception;

public class EntityNotFoundException extends SimpleBankingGlobalException {
    public EntityNotFoundException(String message) {
        super(message);
    }
    public EntityNotFoundException() {
        super("Requested entity not present in the DB.", GlobalErrorCode.ERROR_ENTITY_NOT_FOUND);


    }
}
