package com.ms.employeedemo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@NoArgsConstructor
public class DepartmentDto {

    private Long id;

    private String departmentName;
}
