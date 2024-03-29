package com.answer.ems.controller;


import com.answer.ems.dto.DepartmentDto;
import com.answer.ems.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;


    //building REST API FOR CREATE DEPARTMENT


    @PostMapping()
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
    //building REST API FOR get Department

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {
        DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departments = departmentService.getAllDepartment();
        return ResponseEntity.ok(departments);

    }

    @PutMapping("{id}")

    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                          @RequestBody DepartmentDto updatedDepartment) {
        DepartmentDto departmentDto = departmentService.updateDepartment(departmentId, updatedDepartment);
        return ResponseEntity.ok(departmentDto);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<String>deleteDepartment( @PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department Deleted Successfully");
    }


}

