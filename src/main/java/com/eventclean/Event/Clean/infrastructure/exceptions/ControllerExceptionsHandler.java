package com.eventclean.Event.Clean.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionsHandler {
    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateEventException(DuplicateEventException exception){
        Map<String, String> response = new HashMap<>();
        response.put("Error", "Por favor insira um hashId valido e tente novamente." + exception.getMessage() );
    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(NotFoundEventoexception.class)
    public ResponseEntity<Map<String, String>> handleDNotFoundEventException(NotFoundEventoexception exception){
        Map<String, String> response = new HashMap<>();
        response.put("Erro", "Não foi encontrado nenhum evento com esse identificador: " + exception.getMessage() );
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
