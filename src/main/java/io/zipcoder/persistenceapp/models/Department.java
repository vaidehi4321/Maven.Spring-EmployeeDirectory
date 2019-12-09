package io.zipcoder.persistenceapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private Long departmentNumber;

    private String departmentName;
    @ManyToOne
    private Employee departmentManager;

    public Department( String departmentName, Employee departmentManager) {

        this.departmentName = departmentName;
        this.departmentManager = departmentManager;
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



    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentManager(Employee departmentManager) {
        this.departmentManager = departmentManager;
    }
}
