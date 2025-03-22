package com.mwu.exception;
public class UserAlreadyRegisteredException extends SimpleBankingGlobalException {
    public UserAlreadyRegisteredException(String message, String code) {
        super(message, code);
    }
}
