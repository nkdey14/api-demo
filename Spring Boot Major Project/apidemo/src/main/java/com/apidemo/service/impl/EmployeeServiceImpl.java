package com.apidemo.service.impl;

import com.apidemo.entity.Employee;
import com.apidemo.payload.EmployeeDto;
import com.apidemo.repository.EmployeeRepository;
import com.apidemo.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // Constructor based Dependency Injection
    private EmployeeRepository empRepo;

    public EmployeeServiceImpl(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    @Override
    public EmployeeDto createEmpRegistration(EmployeeDto employeeDto) {

        Employee employee = convertDtoToEntity(employeeDto);
        Employee savedEmployee = empRepo.save(employee);
        return convertEntityToDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(long id) {
        empRepo.deleteById(id);
    }

    Employee convertDtoToEntity(EmployeeDto employeeDto){

        Employee employee = new Employee();

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setDesignation(employeeDto.getDesignation());
        employee.setGender(employeeDto.getGender());
        employee.setEmail(employeeDto.getEmail());
        employee.setMobile(employeeDto.getMobile());
        employee.setCity(employeeDto.getCity());
        employee.setSalary(employeeDto.getSalary());

        return employee;
    }

    EmployeeDto convertEntityToDto(Employee employee){

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setDesignation(employee.getDesignation());
        employeeDto.setGender(employee.getGender());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setMobile(employee.getMobile());
        employeeDto.setCity(employee.getCity());
        employeeDto.setSalary(employee.getSalary());

        return employeeDto;
    }
}
