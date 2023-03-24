package com.example.springbootcrud;

import com.example.springbootcrud.model.Employee;
import com.example.springbootcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrudApplication.class, args);
    }


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Vetti");
        employee.setLastName("Maran");
        employee.setEmailID("Vettimaran@gmail.com");
        employeeRepository.save(employee);

//        Employee employee1 = new Employee();
//        employee1.setFirstName("Edwin");
//        employee1.setLastName("Mose");
//        employee1.setEmailID("Edwinmose@gmail.com");
//        employeeRepository.save(employee1);
//
//        Employee employee2 = new Employee();
//        employee2.setFirstName("Lasith");
//        employee2.setLastName("Malinga");
//        employee2.setEmailID("lasithmalinga96@gmail.com");
//        employeeRepository.save(employee2);

    }
}
