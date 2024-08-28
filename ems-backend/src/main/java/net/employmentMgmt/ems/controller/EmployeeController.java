package net.employmentMgmt.ems.controller;

import lombok.AllArgsConstructor;

import lombok.extern.java.Log;
import net.employmentMgmt.ems.dto.employeeDto;
import net.employmentMgmt.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    private EmployeeService employeeService;

    // Build Add Employee REST API

    @PostMapping

    public ResponseEntity<employeeDto> createEmployee(@RequestBody employeeDto EmployeeDto){
        employeeDto savedEmployee = employeeService.createEmployee(EmployeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    //BUILD GET EMPLOYEE REST API

    @GetMapping ("{id}")

    public ResponseEntity<employeeDto> getEmployeebyID(@PathVariable("id") Long employeeID){
        employeeDto EmployeeDto = employeeService.getEmployeeById(employeeID);
        return ResponseEntity.ok(EmployeeDto);
    }

    //BUILD GET ALL EMPPLOYEES REST API

    @GetMapping

    public ResponseEntity<List<employeeDto>> getAllEmployees(){
        List<employeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // BUILD UPDATE EMPLOYEE REST API

    @PutMapping("{id}")

    public ResponseEntity<employeeDto> updateEmployee(@PathVariable("id") Long EmployeeId,
                                                      @RequestBody employeeDto updatedEmployee){
       employeeDto EmployeeDto= employeeService.updateEmployee(EmployeeId, updatedEmployee);
       return ResponseEntity.ok(EmployeeDto);


    }

    // BUILD DELETE EMPLOYEE REST API

    @DeleteMapping("{id}")

    public ResponseEntity<String> DeleteEmployee(@PathVariable("id") Long EmployeeId){
       String EmployeeDto= employeeService.deleteEmployee(EmployeeId);
       return ResponseEntity.ok(EmployeeDto);

    }




}
