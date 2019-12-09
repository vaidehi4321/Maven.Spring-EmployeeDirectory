package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DepartmentController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department/")
    public ResponseEntity<Iterable<Department>> index() {
        return new ResponseEntity<>(departmentService.index(), HttpStatus.OK);
    }

    @GetMapping("/department/{departmentNumber}")
    public ResponseEntity<Department> show(@PathVariable Long departmentNumber) {
        return new ResponseEntity<>(departmentService.show(departmentNumber), HttpStatus.OK);
    }

    @PostMapping("/department/")
    public ResponseEntity<Department> create(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.create(department), HttpStatus.CREATED);
    }

    @PutMapping("/department/{departmentNumber}")
    public ResponseEntity<Department> update(@PathVariable Long departmentNumber, @RequestBody Department department) {
        return new ResponseEntity<>(departmentService.update(departmentNumber, department), HttpStatus.OK);
    }

    @DeleteMapping("/department/{departmentNumber}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long departmentNumber) {
        return new ResponseEntity<>(departmentService.delete(departmentNumber), HttpStatus.OK);
    }

}
