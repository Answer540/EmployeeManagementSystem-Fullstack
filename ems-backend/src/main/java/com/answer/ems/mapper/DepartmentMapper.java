package com.answer.ems.mapper;

import com.answer.ems.dto.DepartmentDto;
import com.answer.ems.entity.Department;

public class DepartmentMapper {

    //convert department jpa entity to department dto


    public static DepartmentDto mapDepartmentDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()

        );

    }

    //Convert department DTO into department entity
    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );

    }
}
