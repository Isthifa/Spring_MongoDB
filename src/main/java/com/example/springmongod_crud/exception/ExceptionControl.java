package com.example.springmongod_crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionControl {

    @ExceptionHandler
    public ResponseEntity<EmployeeException> handleException(EmployeeNotFound employeeNotFound)
    {
        EmployeeException error=new EmployeeException();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(employeeNotFound.getMessage());
        error.setDate(new Date());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeException> handleException(Exception exception)
    {
        EmployeeException error=new EmployeeException();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setDate(new Date());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
