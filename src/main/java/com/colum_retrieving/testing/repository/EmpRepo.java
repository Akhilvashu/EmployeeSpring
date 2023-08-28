package com.colum_retrieving.testing.repository;

import com.colum_retrieving.testing.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Long> {

    @Query(value = "SELECT department_name FROM Database.department;",nativeQuery = true)
    List<String> findDepartmentNames();

    @Query(value="SELECT * FROM Database.employee ORDER BY salary asc;",nativeQuery = true)
    List<Employee> sortedemployeelist();

    @Query(value = "SELECT * FROM Database.employee order by salary desc;",nativeQuery = true)
    List<Employee> dsortedemployeelist();
}
