package com.answer.ems.service;

import com.answer.ems.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long departmentId);
    List<DepartmentDto> getAllDepartment();

    DepartmentDto updateDepartment(long departmentId,DepartmentDto departmentDto);

    void deleteDepartment(Long departmentId);




}
