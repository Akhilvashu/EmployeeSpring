package com.colum_retrieving.testing.service;

import com.colum_retrieving.testing.entity.Department;
import com.colum_retrieving.testing.repository.DepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepService {

    @Autowired
    private DepRepo Drepo;

    public List<Department> findDepartmentsByNames(List<String> departmentNames) {
        return Drepo.findBydepnameIn(departmentNames);
    }

}
