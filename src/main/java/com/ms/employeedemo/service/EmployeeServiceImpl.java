package com.ms.employeedemo.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.employeedemo.dto.EmployeeDto;
import com.ms.employeedemo.dto.ResponseDto;
import com.ms.employeedemo.entity.Employee;
import com.ms.employeedemo.repository.DepartmentRepo;
import com.ms.employeedemo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmpolyeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public ResponseDto getAll() {
        ResponseDto responseDto = new ResponseDto();
        try {
            List<Employee> employeeList = employeeRepo.findAll();
            if (!employeeList.isEmpty()) {
                responseDto.setCode("200");
                responseDto.setMessage("data fetch successfully");
                responseDto.setData(employeeList);
            } else {
                responseDto.setCode("200");
                responseDto.setMessage("No data found");
            }
        } catch (Exception ex) {
            responseDto.setCode("400");
            responseDto.setMessage(ex.getMessage());
        }
        return responseDto;
    }

    @Override
    public ResponseDto addEmp(EmployeeDto employeeDto) {
        ResponseDto responseDto = new ResponseDto();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Employee employee = objectMapper.convertValue(employeeDto, Employee.class);
            Employee employee1 = employeeRepo.save(employee);
            if (employee1.getId() != 0) {
                responseDto.setCode("201");
                responseDto.setMessage("created");
                responseDto.setData(employee1);
            } else {
                responseDto.setCode("400");
                responseDto.setMessage("failed");
            }
        } catch (Exception ex) {
            responseDto.setCode("400");
            responseDto.setMessage(ex.getMessage());
        }

        return responseDto;
    }

    @Override
    public ResponseDto editEmp(EmployeeDto employeeDto) {
        ResponseDto responseDto = new ResponseDto();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Employee employee = objectMapper.convertValue(employeeDto, Employee.class);
            Employee employee1 = employeeRepo.save(employee);
            if (employee1.getId() != 0) {
                responseDto.setCode("200");
                responseDto.setMessage("updated");
                responseDto.setData(employee1);
            } else {
                responseDto.setCode("400");
                responseDto.setMessage("failed");
            }
        } catch (Exception ex) {
            responseDto.setCode("400");
            responseDto.setMessage(ex.getMessage());
        }
        return responseDto;
    }

    @Override
    public ResponseDto deleteEmp(Long id) {
        ResponseDto responseDto = new ResponseDto();
        try {
            boolean isExist = employeeRepo.existsById(id);
            if (isExist) {
                employeeRepo.deleteById(id);
                responseDto.setCode("200");
                responseDto.setMessage("delete done");
            } else {
                responseDto.setCode("400");
                responseDto.setMessage("employee does not exist");
            }
        } catch (Exception ex) {
            responseDto.setCode("400");
            responseDto.setMessage(ex.getMessage());
        }
        return responseDto;
    }
}
