package com.example.springmongod_crud.exception;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeException {
    private int status;

    private String message;

    private Date date;

}
