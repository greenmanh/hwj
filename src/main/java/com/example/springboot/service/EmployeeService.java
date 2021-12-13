package com.example.springboot.service;

import com.example.springboot.domain.Department2;
import com.example.springboot.domain.Employee2;
import com.example.springboot.dto.Employee2Dto;

import java.util.Collection;


public interface EmployeeService {
    public Boolean addEmp(Employee2 employee);

    Collection<Employee2Dto> findEmp();

    Collection<Department2> finDep();

    Employee2 findEmp(Integer id);

    void editEmp(Employee2 employee2);

    void deleteEmp(Integer id);
}
