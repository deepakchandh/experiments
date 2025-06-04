package com.java.empservice.repository;

import com.java.empservice.dto.APIResponseDto;
import com.java.empservice.dto.DepartmentDto;
import com.java.empservice.dto.EmployeeDto;
import com.java.empservice.entity.Employee;
import com.java.empservice.mapper.EmployeeMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;
    private APIClient apiClient;

//   private RestTemplate restTemplate;
   private WebClient webClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee saveDEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);

        return savedEmployeeDto;
    }

    @CircuitBreaker(name = "EMPLOYEE-SERVICE", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

//        DepartmentDto deptdto = apiClient.getDepartment(employee.getDepartmentCode());

        DepartmentDto deptdto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
//        ResponseEntity<DepartmentDto> deptdto =
//                restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
        return  new APIResponseDto(EmployeeMapper.mapToEmployeeDto(employee), deptdto);
    }

    public APIResponseDto getDefaultDepartment(Long empId,  Exception exception){
        Employee employee = employeeRepository.findById(empId).get();
        DepartmentDto deptdto = new DepartmentDto();
        deptdto.setId(88l);
        deptdto.setDepartmentName("Research dept");
        deptdto.setDepartmentDescription("ahjdajshdashd");
        deptdto.setDepartmentCode("RansD");
        return new APIResponseDto(EmployeeMapper.mapToEmployeeDto(employee), deptdto);
    }

}
