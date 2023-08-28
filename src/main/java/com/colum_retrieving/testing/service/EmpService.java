package com.colum_retrieving.testing.service;

import com.colum_retrieving.testing.entity.Employee;
import com.colum_retrieving.testing.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepo SRepo;

    public List<String> getDepartmentNames() {
        return SRepo.findDepartmentNames();
    }

    public void save(Employee employee) {
        SRepo.save(employee);
    }

    public List<Employee> list() {
        return SRepo.findAll();
    }

    public List<Employee> SortedEmp(){
        return SRepo.sortedemployeelist();
    }

    public List<Employee> DSortedEmp() {
        return SRepo.dsortedemployeelist();
    }
}


