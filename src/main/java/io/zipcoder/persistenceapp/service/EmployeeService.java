package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    //instance of the corresponding repository
@Autowired
    private EmployeeRepository repository;


    //now the constructor
    @Autowired
    public EmployeeService(EmployeeRepository repository){this.repository = repository;}

    //now the crud operations simulator

    public Iterable<Employee> index(){return repository.findAll();}

    public Employee show(Long employeeId){
        return repository.findOne(employeeId);}

    public Employee create(Employee employee){return repository.save(employee);}

    public Employee update(Long id,Employee newEmployeeData){
        Employee originalEmployee = repository.findOne(id);

        originalEmployee.setFirstName(newEmployeeData.getFirstName());
        originalEmployee.setLastName(newEmployeeData.getLastName());
        originalEmployee.setTitle(newEmployeeData.getTitle());
        originalEmployee.setPhoneNumber(newEmployeeData.getPhoneNumber());
        originalEmployee.setEmail(newEmployeeData.getEmail());
        originalEmployee.setManager(newEmployeeData.getManager());
        originalEmployee.setDepartmentNumber(newEmployeeData.getDepartmentNumber());
        return repository.save(originalEmployee);
    }

    public Boolean delete(Long id){
       repository.delete(id);
       return true;
    }






}
