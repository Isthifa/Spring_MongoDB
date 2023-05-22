package com.example.springmongod_crud.controller;

import com.example.springmongod_crud.entity.Employee;
import com.example.springmongod_crud.service.Services;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeRest {
    private Services services;

    @Autowired
    public EmployeeRest(Services services)
    {
        this.services=services;
    }

    @GetMapping("/listall")
    @Operation(summary = "List all employees")
    public List<Employee> listall()
    {
        return services.listall();
    }

    @PostMapping("/save")
    @Operation(summary = "Saving the employee")
    public Employee save(@RequestBody Employee employee)
    {
        List<Employee> employee1=services.listall();
        System.out.println(employee1.size());
        Employee employee2=new Employee();
        employee2.setId(employee1.size()+1);
        employee2.setEmpName(employee.getEmpName());
        employee2.setEmpSalary(employee.getEmpSalary());
        return services.save(employee2);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Employee by id")
    public Employee update(@RequestBody Employee employee,@PathVariable int id)
    {
        Employee employee1=services.findbyid(id);
        employee1.setId(employee.getId());
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        services.save(employee1);
        return employee1;
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "Find employee by id")
    public Employee findbyid(@PathVariable int id)
    {
        Employee employee=services.findbyid(id);
        return employee;
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete employee by id")
    public ResponseEntity<?> delete(@PathVariable int id)
    {
        services.deletebyid(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
