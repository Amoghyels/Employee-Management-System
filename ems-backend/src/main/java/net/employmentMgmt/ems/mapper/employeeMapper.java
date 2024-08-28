package net.employmentMgmt.ems.mapper;

import net.employmentMgmt.ems.dto.employeeDto;
import net.employmentMgmt.ems.entity.employee;

public class employeeMapper {
    public static employeeDto mapToemployeeDto(employee Employee){
        return new employeeDto(
                Employee.getId(),
                Employee.getFirstName(),
                Employee.getLastName(),
                Employee.getEmail()
        );

    }
    public static employee mapToemployee(employeeDto EmployeeDTo){
        return new employee(
                EmployeeDTo.getId(),
                EmployeeDTo.getFirstName(),
                EmployeeDTo.getLastName(),
                EmployeeDTo.getEmail()

        );
    }
}
