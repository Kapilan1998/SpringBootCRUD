package com.example.springbootcrud.controller;

import com.example.springbootcrud.exception.ResouceNotFoundException;
import com.example.springbootcrud.model.Employee;
import com.example.springbootcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // build RESTful web services and handle http request
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //build create employee REST API
    @PostMapping      // used when inserting data
    public Employee createEmployee(@RequestBody Employee employee){    //@RequestBody is converting json to java object
        return employeeRepository.save(employee);
    }

    //build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Sorry, employee with id = "+id+" is not exist"));
        return ResponseEntity.ok(employee);
    }

    //build update employee REST API
    @PutMapping("{id}")  // used when updating data
    public  ResponseEntity<Employee> updateEmployee(@PathVariable  long id, @RequestBody Employee employeeDetails){
          Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() ->new ResouceNotFoundException("Sorry, employee with id = "+id+" is not exist"));

          updateEmployee.setFirstName(employeeDetails.getFirstName());
          updateEmployee.setLastName((employeeDetails.getLastName()));
          updateEmployee.setEmailID((employeeDetails.getEmailID()));

          employeeRepository.save(updateEmployee);
          return ResponseEntity.ok(updateEmployee);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->new ResouceNotFoundException("Sorry, employee with id = "+id+" is not exist"));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
