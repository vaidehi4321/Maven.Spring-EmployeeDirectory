package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    //instance of the corresponding repository

    private EmployeeRepository repository;

    //now the constructor
    @Autowired
    public EmployeeService(EmployeeRepository repository){this.repository = repository;}

    //now the crud operations simulator

    public Iterable<Employee> index(){return repository.findAll();}

    public Employee show(Long employeeId){ return repository.findById(employeeId).get();}

    public Employee create(Employee employee){return repository.save(employee);}

    public Employee update(Long id,Employee newEmployeeData){
        Employee originalEmployee = repository.findById(id).get();
        originalEmployee.setFirstName(newEmployeeData.getFirstName());
        originalEmployee.setLastName(newEmployeeData.getLastName());
        originalEmployee.setTitle(newEmployeeData.getTitle());
        originalEmployee.setPhoneNumber(newEmployeeData.getPhoneNumber());
        originalEmployee.setEmail(newEmployeeData.getEmail());
        originalEmployee.setHireDate(newEmployeeData.getHireDate());
        originalEmployee.setManager(newEmployeeData.getManager());
        originalEmployee.setDepartmentNumber(newEmployeeData.getDepartmentNumber());
        return repository.save(originalEmployee);
    }

    public Boolean delete(Long id){
       repository.deleteById(id);
       return true;
    }


}
