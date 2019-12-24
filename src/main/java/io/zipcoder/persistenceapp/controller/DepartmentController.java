package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/API/department/")
    public ResponseEntity<Iterable<Department>> index() {
        return new ResponseEntity<>(departmentService.index(), HttpStatus.OK);
    }

    @GetMapping("/API/department/{departmentNumber}")
    public ResponseEntity<Department> show(@PathVariable Long departmentNumber) {
        return new ResponseEntity<>(departmentService.show(departmentNumber), HttpStatus.OK);
    }

    @PostMapping("/API/department/")
    public ResponseEntity<Department> create(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.create(department), HttpStatus.CREATED);
    }

    @PutMapping("/API/department/{departmentNumber}")
    public ResponseEntity<Department> update(@PathVariable Long departmentNumber, @RequestBody Department department) {
        return new ResponseEntity<>(departmentService.update(departmentNumber, department), HttpStatus.OK);
    }

    @DeleteMapping("/API/department/{departmentNumber}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long departmentNumber) {
        return new ResponseEntity<>(departmentService.delete(departmentNumber), HttpStatus.OK);
    }



}
/*
{"departmentName":"math","manger":null}

*/