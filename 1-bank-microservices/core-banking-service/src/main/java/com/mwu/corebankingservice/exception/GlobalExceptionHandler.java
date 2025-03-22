package com.mwu.corebankingservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SimpleBankingGlobalException.class)
    protected ResponseEntity handleGlobalException(SimpleBankingGlobalException ex, Locale locale) {
        return ResponseEntity
                .badRequest()
                .body(ErrorResponse.builder()
                        .code(ex.getCode())
                        .message(ex.getMessage())
                        .build());
    }

    @ExceptionHandler({Exception.class})
    private ResponseEntity handleException(Exception ex, Locale locale) {
        return ResponseEntity
                .badRequest()
                .body("Internal Server Error" + ex.getMessage());
    }

}
