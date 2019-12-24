package io.zipcoder.persistenceapp.models;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private Long departmentNumber;

    private String departmentName;


   @ManyToOne
    private Employee departmentManager;

    public Department(){

    }

    public Long getDepartmentNumber() {
        return departmentNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Employee getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentNumber(Long departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentManager(Employee departmentManager) {
        this.departmentManager = departmentManager;
    }


}
