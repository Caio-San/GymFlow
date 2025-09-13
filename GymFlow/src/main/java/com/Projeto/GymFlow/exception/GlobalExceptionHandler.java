package com.Projeto.GymFlow.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;



@RestControllerAdvice
public class GlobalExceptionHandler {

    // Captura erros de validação dos DTOs
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

    // Captura IllegalArgumentException (como no caso da data de presença inválida)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentExceptions(
            IllegalArgumentException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("erro", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
