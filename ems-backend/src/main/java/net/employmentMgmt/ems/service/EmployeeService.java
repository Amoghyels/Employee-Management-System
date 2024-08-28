package net.employmentMgmt.ems.service;

import net.employmentMgmt.ems.dto.employeeDto;

import java.util.List;

public interface EmployeeService {
    employeeDto createEmployee(employeeDto EmployeeDto);
    employeeDto getEmployeeById(Long employeeID);

    List<employeeDto> getAllEmployees();

    employeeDto updateEmployee(Long employeeID, employeeDto updatedEmployee);

    String deleteEmployee(Long employeeId);


}
