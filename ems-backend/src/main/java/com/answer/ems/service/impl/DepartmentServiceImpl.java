package com.answer.ems.service.impl;

import com.answer.ems.dto.DepartmentDto;
import com.answer.ems.entity.Department;
import com.answer.ems.exception.ResourceNotFoundException;
import com.answer.ems.mapper.DepartmentMapper;
import com.answer.ems.repository.DepartmentRepository;
import com.answer.ems.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        //converting DTO to entity object
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        //storing this jpa entity to database
        Department savedDepartment = departmentRepository.save(department);
        //converting savedDepartment object into Department DTO
        return DepartmentMapper.mapDepartmentDto(savedDepartment);
    }


    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department is not exist with given id:" + departmentId));
        return DepartmentMapper.mapDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream().map((department) -> DepartmentMapper.mapDepartmentDto(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(long departmentId, DepartmentDto updatedDepartment) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department is not exist with given department id:" + departmentId));
        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
     departmentRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("Department is not exist with department id"+departmentId));
     departmentRepository.deleteById(departmentId);

    }
}
