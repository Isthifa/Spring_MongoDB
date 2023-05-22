package com.example.springmongod_crud.repository;

import com.example.springmongod_crud.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee,Integer> {
}
