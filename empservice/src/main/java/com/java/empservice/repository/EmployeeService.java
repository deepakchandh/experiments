package com.java.empservice.repository;

import com.java.empservice.dto.APIResponseDto;
import com.java.empservice.dto.EmployeeDto;
import com.java.empservice.entity.Employee;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);

}
