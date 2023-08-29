package com.colum_retrieving.testing.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @Column(name = "Department_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long depid;

    @Column(name = "Department_Name")
    public String depname;

    @ManyToMany(mappedBy = "departments",cascade = CascadeType.REMOVE)
    private Set<Employee> employees = new HashSet<>();

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Long getDepid() {
        return depid;
    }

    public void setDepid(Long depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }
}
