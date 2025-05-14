package com.apidemo.repository;

import com.apidemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // extends JpaRepository<Employee, Long> provides CRUD operations           {
}
