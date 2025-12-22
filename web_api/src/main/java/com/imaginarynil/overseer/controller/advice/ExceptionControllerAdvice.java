package com.imaginarynil.overseer.controller.advice;

import com.imaginarynil.overseer.exception.ItemNotFoundException;
import com.imaginarynil.overseer.model.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(ItemNotFoundException.class)
    ResponseEntity<ErrorMessage> handleItemNotFoundException(ItemNotFoundException exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
