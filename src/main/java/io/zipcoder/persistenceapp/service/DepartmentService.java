package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;

//    public DepartmentService(DepartmentRepository repository) {
//        this.repository = repository;
//    }

    public Iterable<Department> index() {
        return repository.findAll();
    }

    public Department show(Long departmentNumber) {
        return repository.findOne(departmentNumber);
    }

    public Department create(Department department) {
        return repository.save(department);
    }

    public Department update(Long departmentNumber, Department newDepartmentData) {
        Department originalDepartment = repository.findOne(departmentNumber);
        originalDepartment.setDepartmentNumber(newDepartmentData.getDepartmentNumber());
        originalDepartment.setDepartmentName(newDepartmentData.getDepartmentName());
        originalDepartment.setDepartmentManager(newDepartmentData.getDepartmentManager());

        return repository.save(originalDepartment);
    }

    public Boolean delete(Long id) {
        repository.delete(id);

        return true;
    }


}
