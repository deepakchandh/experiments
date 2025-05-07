package net.javaguides.banking.repository;

import net.javaguides.banking.entity.Employeee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employeee, Long>  {
}
