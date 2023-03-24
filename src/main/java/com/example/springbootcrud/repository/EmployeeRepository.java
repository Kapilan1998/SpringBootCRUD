package com.example.springbootcrud.repository;

import com.example.springbootcrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository <Employee,Long>{
    //all CRUD methods

}
