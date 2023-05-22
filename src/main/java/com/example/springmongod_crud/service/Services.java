package com.example.springmongod_crud.service;

import com.example.springmongod_crud.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface Services {

    List<Employee> listall();

    Employee save(Employee employee);

    void deletebyid(int id);

    Employee findbyid(int id);

}
