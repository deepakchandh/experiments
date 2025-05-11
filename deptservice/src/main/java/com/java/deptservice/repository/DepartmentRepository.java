package com.java.deptservice.repository;

import com.java.deptservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    Department findByDepartmentCode(String departmentCode);
}
