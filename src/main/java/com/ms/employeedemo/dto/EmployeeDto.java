package com.ms.employeedemo.dto;

import com.ms.employeedemo.entity.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class EmployeeDto {

    private Long id;

    private String employeeName;

    private Department department;
}
