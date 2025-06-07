package com.apidemo.controller;

import com.apidemo.payload.EmployeeDto;
import com.apidemo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empreg")
public class EmployeeRestController {

    // Constructor based Dependency Injection
    private EmployeeService empService;

    public EmployeeRestController(EmployeeService empService) {
        this.empService = empService;
    }

    //http://localhost:8081/api/v1/empreg

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> dto = empService.getAllEmployees();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> registerEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto empDto = empService.createEmpRegistration(employeeDto);
        return new ResponseEntity<>(empDto, HttpStatus.CREATED);
    }

    // Add methods to handle HTTP requests here
    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(@RequestParam long id) {
        empService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully with ID:" + id, HttpStatus.OK);
    }

    //http://localhost:8081/api/v1/empreg/2
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto dto = empService.updateEmpRegistration(id, employeeDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //http://localhost:8081/api/v1/empreg/byId?id=2
    @GetMapping("/byId")
    public ResponseEntity<EmployeeDto> getEmployeeDetails(@RequestParam Long id){
        EmployeeDto dto = empService.getEmpById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
