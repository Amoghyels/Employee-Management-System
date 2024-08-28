package net.employmentMgmt.ems.service.impl;

import lombok.AllArgsConstructor;
import net.employmentMgmt.ems.dto.employeeDto;
import net.employmentMgmt.ems.entity.employee;
import net.employmentMgmt.ems.exception.ResourceNotFoundException;
import net.employmentMgmt.ems.mapper.employeeMapper;
import net.employmentMgmt.ems.repository.EmployeeRepository;
import net.employmentMgmt.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public employeeDto createEmployee(employeeDto EmployeeDto) {

        employee Employee = employeeMapper.mapToemployee(EmployeeDto);
        employee savedEmployee = employeeRepository.save(Employee);


        return employeeMapper.mapToemployeeDto(savedEmployee);
    }

    @Override
    public employeeDto getEmployeeById(Long employeeID) {
        employee Employee = employeeRepository.findById(employeeID)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not exists with the given ID: " + employeeID));

        return employeeMapper.mapToemployeeDto(Employee);
    }

    @Override
    public List<employeeDto> getAllEmployees() {
       List<employee> Employees =  employeeRepository.findAll();
        return Employees.stream().map((employee) -> employeeMapper.mapToemployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public employeeDto updateEmployee(Long employeeID, employeeDto updatedEmployee) {
        employee Employee = employeeRepository.findById(employeeID).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with the given ID: " + employeeID)
        );

        Employee.setFirstName(updatedEmployee.getFirstName());
        Employee.setLastName(updatedEmployee.getLastName());
        Employee.setEmail(updatedEmployee.getEmail());

       employee updatedEmployeeObj = employeeRepository.save(Employee);

        return employeeMapper.mapToemployeeDto(updatedEmployeeObj);
    }

    @Override
    public String deleteEmployee(Long employeeId) {
        employee Employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with the given ID: " + employeeId)
        );
        employeeRepository.deleteById(employeeId);
        return "ID has deleted";
    }
}
