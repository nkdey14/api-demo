package com.apidemo.service;

import com.apidemo.entity.Employee;
import com.apidemo.payload.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmpRegistration(EmployeeDto employeeDto);

    void deleteEmployee(long id);

    void updateEmpRegistration(long id, EmployeeDto employeeDto);

    List<Employee> getAllEmployees();
}
