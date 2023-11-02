package com.example.cruddemo.repositories;

import com.example.cruddemo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
//    List<Employee> findByName(String name);
    
}
