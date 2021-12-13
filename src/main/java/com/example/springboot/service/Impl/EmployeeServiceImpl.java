package com.example.springboot.service.Impl;

import com.example.springboot.domain.Department2;
import com.example.springboot.domain.Employee2;
import com.example.springboot.dto.Employee2Dto;
import com.example.springboot.mapper.EmployeeMapper;
import com.example.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public Boolean addEmp(Employee2 employee) {
        return employeeMapper.addEmp(employee);
    }

    @Override
    public Collection<Employee2Dto> findEmp() {
        return employeeMapper.findEmp();
    }

    @Override
    public Collection<Department2> finDep() {
        return employeeMapper.findDept();
    }

    @Override
    public Employee2 findEmp(Integer id) {
        return employeeMapper.findEmp2(id);
    }

    @Override
    public void editEmp(Employee2 employee2) {
        employeeMapper.editEmp(employee2);
    }

    @Override
    public void deleteEmp(Integer id) {
        employeeMapper.deleteEmp(id);
    }
}
