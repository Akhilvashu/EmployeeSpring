package com.colum_retrieving.testing.repository;

import com.colum_retrieving.testing.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepRepo extends JpaRepository<Department,Long> {
    List<Department> findBydepnameIn(List<String> departmentNames);
}
