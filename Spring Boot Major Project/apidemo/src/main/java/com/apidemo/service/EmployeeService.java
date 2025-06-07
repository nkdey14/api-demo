package com.apidemo.service;

import com.apidemo.payload.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmpRegistration(EmployeeDto employeeDto);

    void deleteEmployee(long id);

    EmployeeDto updateEmpRegistration(long id, EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees(int pageNo, int pageSize, String sortBy, String sortDir);

    EmployeeDto getEmpById(Long id);
}
