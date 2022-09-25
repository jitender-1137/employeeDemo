package com.ms.employeedemo.service;

import com.ms.employeedemo.dto.EmployeeDto;
import com.ms.employeedemo.dto.ResponseDto;

public interface EmpolyeeService {
    ResponseDto getAll();

    ResponseDto addEmp(EmployeeDto employeeDto);

    ResponseDto editEmp(EmployeeDto employeeDto);

    ResponseDto deleteEmp(Long id);
}
