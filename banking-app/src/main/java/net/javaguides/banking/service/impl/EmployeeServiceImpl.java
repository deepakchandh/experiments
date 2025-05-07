package net.javaguides.banking.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.banking.dto.EmployeeDto;
import net.javaguides.banking.entity.Employeee;
import net.javaguides.banking.repository.EmployeeRepository;
import net.javaguides.banking.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employeee employeee = modelMapper.map(employeeDto, Employeee.class);
        Employeee saved = employeeRepository.save(employeee);
        return modelMapper.map(saved, EmployeeDto.class);
    }
}
