package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/testss")
    public String testMe() {
        return "it Works";
    }

    @GetMapping("/API/employee/")
    public ResponseEntity<Iterable<Employee>> index() {
        return new ResponseEntity<>(employeeService.index(), HttpStatus.OK);
    }

    @GetMapping("/API/employee/{id}")
    public ResponseEntity<Employee> show(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.show(id), HttpStatus.OK);
    }

    @PostMapping("/API/employee/")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.create(employee), HttpStatus.CREATED);
    }

    @PutMapping("/API/employee/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.update(id, employee), HttpStatus.OK);
    }

    @DeleteMapping("/API/employee/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/API/employee/{id}")
    public ResponseEntity<Employee> findManager(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.findManager(id), HttpStatus.OK);
    }

}
//       {
//        "firstName": "rashmi",
//        "lastName": "bapat",
//        "title":"TechLead",
//        "phoneNumber": "100836",
//        "email": "rash@test.com",
//        "manager": {"employeeNumber":1}
//        }