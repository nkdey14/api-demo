package com.apidemo.service.impl;

import com.apidemo.entity.Employee;
import com.apidemo.exception.ResourceNotFoundException;
import com.apidemo.payload.EmployeeDto;
import com.apidemo.repository.EmployeeRepository;
import com.apidemo.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // Constructor based Dependency Injection
    private EmployeeRepository empRepo;

    public EmployeeServiceImpl(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto createEmpRegistration(EmployeeDto employeeDto) {

        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = empRepo.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(long id) {
        empRepo.deleteById(id);
    }

    @Override
    public EmployeeDto updateEmpRegistration(long id, EmployeeDto employeeDto) {

        Optional<Employee> optionalEmployee = empRepo.findById(id);

        if(optionalEmployee.isPresent()) {

            Employee employee = optionalEmployee.get();

          //  employee.setId(employeeDto.getId());
            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setDesignation(employeeDto.getDesignation());
            employee.setGender(employeeDto.getGender());
            employee.setEmail(employeeDto.getEmail());
            employee.setMobile(employeeDto.getMobile());
            employee.setCity(employeeDto.getCity());
            employee.setSalary(employeeDto.getSalary());

            // Save the updated employee
            Employee savedEmpData = empRepo.save(employee);

            return modelMapper.map(savedEmpData, EmployeeDto.class);
        }else{
            throw new RuntimeException("Employee not found with ID: " + id);
        }

    }

    // http://localhost:8081/api/v1/empreg/employees?pageNo=0&pageSize=4&sortBy=lastName&sortDir=asc

    @Override
    public List<EmployeeDto> getAllEmployees(int pageNo, int pageSize, String sortBy, String sortDir) {

        // Create a Sort object based on sortDir
        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        // Create a Pageable object with sorting
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Employee> all = empRepo.findAll(pageable);
        List<Employee> employees = all.getContent();
        return employees.stream().map(e -> convertEntityToDto(e)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmpById(Long id) {
        Employee employee = empRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with ID: " + id)
        );
        return modelMapper.map(employee, EmployeeDto.class);
    }

    Employee convertDtoToEntity(EmployeeDto employeeDto){

//        Employee employee = new Employee();
//
//        employee.setFirstName(employeeDto.getFirstName());
//        employee.setLastName(employeeDto.getLastName());
//        employee.setDesignation(employeeDto.getDesignation());
//        employee.setGender(employeeDto.getGender());
//        employee.setEmail(employeeDto.getEmail());
//        employee.setMobile(employeeDto.getMobile());
//        employee.setCity(employeeDto.getCity());
//        employee.setSalary(employeeDto.getSalary());

        return modelMapper.map(employeeDto, Employee.class);
    }

    EmployeeDto convertEntityToDto(Employee employee){

//        EmployeeDto employeeDto = new EmployeeDto();
//
//        employeeDto.setId(employee.getId());
//        employeeDto.setFirstName(employee.getFirstName());
//        employeeDto.setLastName(employee.getLastName());
//        employeeDto.setDesignation(employee.getDesignation());
//        employeeDto.setGender(employee.getGender());
//        employeeDto.setEmail(employee.getEmail());
//        employeeDto.setMobile(employee.getMobile());
//        employeeDto.setCity(employee.getCity());
//        employeeDto.setSalary(employee.getSalary());

        return modelMapper.map(employee, EmployeeDto.class);
    }
}

