package com.example.springmongod_crud.service;

import com.example.springmongod_crud.entity.Employee;
import com.example.springmongod_crud.exception.EmployeeNotFound;
import com.example.springmongod_crud.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements Services{


    private EmployeeRepo employeeRepo;
    @Autowired
    public ServiceImpl(EmployeeRepo employeeRepo)
    {
        this.employeeRepo=employeeRepo;
    }
    @Override
    public List<Employee> listall() {
        List<Employee> employeeLists=employeeRepo.findAll();
         return employeeLists;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deletebyid(int id) {
        Optional<Employee> employee=employeeRepo.findById(id);
        if(!employee.isPresent())
        {
             throw new EmployeeNotFound("Employee Not Found");
        }
        else {
            employeeRepo.deleteById(id);
        }
    }

    @Override
    public Employee findbyid(int id) {
        return employeeRepo.findById(id).orElseThrow(()->new EmployeeNotFound("Employee NOT FOUND"));
    }

}
