package com.java.empservice.repository;

import com.java.empservice.dto.EmployeeDto;
import com.java.empservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
