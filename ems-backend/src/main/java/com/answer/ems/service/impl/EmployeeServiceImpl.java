package com.answer.ems.service.impl;

import com.answer.ems.dto.EmployeeDto;
import com.answer.ems.entity.Department;
import com.answer.ems.entity.Employee;
import com.answer.ems.exception.ResourceNotFoundException;
import com.answer.ems.mapper.EmployeeMapper;
import com.answer.ems.repository.DepartmentRepository;
import com.answer.ems.repository.EmployeeRepository;
import com.answer.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department is not exist with this department Id" + employeeDto.getDepartmentId()));
        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exist with given id:" + employeeId));
        return EmployeeMapper.mapEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with this employeeId:" + employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName((updatedEmployee.getLastName()));
        employee.setEmail(updatedEmployee.getEmail());

        Department department = departmentRepository.findById(updatedEmployee.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department is not exist with this department Id" + updatedEmployee.getDepartmentId()));
        employee.setDepartment(department);


        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with this employeeId:" + employeeId));

        employeeRepository.deleteById(employeeId);
    }

    //
}
