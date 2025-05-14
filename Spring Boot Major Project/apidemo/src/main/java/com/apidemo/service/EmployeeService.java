package com.apidemo.service;

import com.apidemo.payload.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmpRegistration(EmployeeDto employeeDto);

    void deleteEmployee(long id);
}
