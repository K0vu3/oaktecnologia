package br.com.oaktecnologia.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity hadleEntityNotFoundException() {
        return ResponseEntity.notFound().build();
    }

}
