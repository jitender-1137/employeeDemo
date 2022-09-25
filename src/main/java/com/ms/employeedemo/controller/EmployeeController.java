package com.ms.employeedemo.controller;

import com.ms.employeedemo.dto.EmployeeDto;
import com.ms.employeedemo.dto.ResponseDto;
import com.ms.employeedemo.service.EmpolyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmpolyeeService employeeService;

    @GetMapping("/allEmp")
    public ResponseDto getAll(){
        ResponseDto responseDto = employeeService.getAll();
        return responseDto;
    }

    @PostMapping("/addEmp")
    public ResponseDto addEmp(@RequestBody EmployeeDto employeeDto){
        ResponseDto responseDto = employeeService.addEmp(employeeDto);
        return responseDto;
    }

    @PutMapping("/editEmp")
    public ResponseDto editEmp(@RequestBody EmployeeDto employeeDto){
        ResponseDto responseDto = employeeService.editEmp(employeeDto);
        return responseDto;
    }

    @DeleteMapping("/deleteEmp{id}")
    public ResponseDto deleteEmp(@RequestParam("id") Long id){
        ResponseDto responseDto = employeeService.deleteEmp(id);
        return responseDto;
    }
}
