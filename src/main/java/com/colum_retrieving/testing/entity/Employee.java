package com.colum_retrieving.testing.entity;

import com.colum_retrieving.testing.entity.Department;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @Column(name = "Employee_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long empid;

    @Column(name = "Name")
    public String name;

    @Column(name = "Age")
    public int age;

    @Column(name= "Profile")
    public String profile;

    @Column(name = "Salary")
    public int Salary;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable( name = "Emp_dep",
            joinColumns = @JoinColumn(name = "Employee_Id"),
            inverseJoinColumns = @JoinColumn(name = "Department_Id")
    )
    private Set<Department> departments = new HashSet<>();

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Long getEmpid() {
        return empid;
    }

    public void setEmpid(Long empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}
