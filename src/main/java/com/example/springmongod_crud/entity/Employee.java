package com.example.springmongod_crud.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Employee {
    @Id
    private int id;
    private String empName;
    private String empSalary;

}
