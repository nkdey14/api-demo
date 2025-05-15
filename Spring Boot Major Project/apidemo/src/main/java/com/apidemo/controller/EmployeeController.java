package com.apidemo.controller;

import com.apidemo.entity.Employee;
import com.apidemo.payload.EmployeeDto;
import com.apidemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empreg")
public class EmployeeController {

    // Constructor based Dependency Injection
    private EmployeeService empService;

    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    //http://localhost:8081/api/v1/empreg

    @PostMapping
    public String registerEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto empDto = empService.createEmpRegistration(employeeDto);
        return "Employee registered successfully with ID:" + empDto.getId();
    }

    // Add methods to handle HTTP requests here
    @DeleteMapping
    public String deleteEmployee(@RequestParam long id) {
        empService.deleteEmployee(id);
        return "Employee deleted successfully with ID:" + id;
    }

    //http://localhost:8081/api/v1/empreg/2
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable long id, @RequestBody EmployeeDto employeeDto) {
        empService.updateEmpRegistration(id, employeeDto);
        return "Employee updated successfully with ID:" + id;
    }


    @GetMapping
    public List<Employee> getAllEmployees() {
        return empService.getAllEmployees();
    }

}
