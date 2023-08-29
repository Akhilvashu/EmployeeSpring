package com.colum_retrieving.testing.repository;

import com.colum_retrieving.testing.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Long> {

    @Query("SELECT D.depname FROM Department D")
    List<String> findDepartmentNames();

    @Query("SELECT E FROM Employee E ORDER BY E.salary ASC")
    List<Employee> sortedemployeelist();

    @Query("SELECT E FROM Employee E order by E.salary DESC")
    List<Employee> dsortedemployeelist();


    List<Employee> findBySalary(Long Salary);

    List<Employee> findByName(String Empname);
}
