package com.thoughtworks.capacity.gtb.mvc.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(LoginRegisterException.class)
  public ResponseEntity<ErrorResult> handle(LoginRegisterException ex) {
    ErrorResult errorResult = ErrorResult.builder().errorCode(400).message(ex.getMessage()).build();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
  }

  @ExceptionHandler(LoginException.class)
  public ResponseEntity<ErrorResult> handle(LoginException ex) {
    ErrorResult errorResult = ErrorResult.builder().errorCode(400).message(ex.getMessage()).build();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex) {
    String message = ex.getBindingResult().getFieldError().getDefaultMessage();
    ErrorResult errorResult = new ErrorResult(400,message);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResult> handle(ConstraintViolationException ex) {
    Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
    String message = "";
    for (ConstraintViolation<?> constraint : ex.getConstraintViolations()) {
      message = constraint.getMessage();
      break;
    }
    ErrorResult errorResult = new ErrorResult(400,message);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
  }
}
