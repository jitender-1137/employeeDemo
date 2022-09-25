package com.ms.employeedemo.service;

import com.ms.employeedemo.entity.Department;
import com.ms.employeedemo.entity.Employee;
import com.ms.employeedemo.repository.EmployeeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeRepo employeeRepo;

    private Employee employee;
    private Department department;

    @Test
    public void getAll() throws Exception {
        List<Employee> list = employeeRepo.findAll();
        org.assertj.core.api.Assertions.assertThat(list).size().isGreaterThan(0);
    }

    @Test
    public void addEmp() throws Exception {
        employee = new Employee();
        department = new Department();
        employee.setEmployeeName("jitender");
        department.setDepartmentName("sale");
        employee.setDepartment(department);
        Employee employee1 = employeeRepo.save(employee);
        Assertions.assertNotNull(employeeRepo.findById(1L).get());
    }

    @Test
    public void editEmp() throws Exception {
        employee = new Employee();
        department = new Department();
        employee.setId(5L);
        employee.setEmployeeName("rohit");
        department.setId(4L);
        department.setDepartmentName("sale");
        employee.setDepartment(department);
        Employee employee1 = employeeRepo.save(employee);
        Assertions.assertNotNull(employeeRepo.findById(1L).get());
    }

    @Test
    public void deleteEmp() throws Exception {
        employee = new Employee();
        employee.setId(5L);
       employeeRepo.deleteById(employee.getId());
        org.assertj.core.api.Assertions.assertThat(employeeRepo.existsById(employee.getId())).isFalse();
    }
}