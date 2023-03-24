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
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){                     //ResponseEntity is used to return an HTTP response
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Sorry, employee with id = "+id+" is not exist"));
        return ResponseEntity.ok(employee);
    }

    //build update employee REST API
    @PutMapping("{id}")  // used when updating data
                        //@PathVariable is to extract value from URL    and    @RequestBody is to extract request body data as object
    public  ResponseEntity<Employee> updateEmployee(@PathVariable  long id, @RequestBody Employee employeeDetails){
        // find the employee by id, or throw a ResourceNotFoundException if it doesn't exist
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() ->new ResouceNotFoundException("Sorry, employee with id = "+id+" is not exist"));

        // update the employee's details with the new values
        updateEmployee.setFirstName(employeeDetails.getFirstName());
          updateEmployee.setLastName((employeeDetails.getLastName()));
          updateEmployee.setEmailID((employeeDetails.getEmailID()));

        // save the updated employee to the database
        employeeRepository.save(updateEmployee);

        // return the updated employee along with HTTP status code of 200 (200 = OK || SUCESS)
          return ResponseEntity.ok(updateEmployee);
    }


    @DeleteMapping("{id}")     //used when deleting
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){                        //ResponseEntity is used to return an HTTP response
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->new ResouceNotFoundException("Sorry, employee with id = "+id+" is not exist"));
        employeeRepository.delete(employee);

        //ResponseEntity object with HTTP status code of 204 (NO_CONTENT) indicating that deleting request was successful and there is no response body
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
