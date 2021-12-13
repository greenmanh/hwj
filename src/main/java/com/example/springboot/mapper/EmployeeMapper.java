package com.example.springboot.mapper;

import com.example.springboot.domain.Department2;
import com.example.springboot.domain.Employee2;
import com.example.springboot.dto.Employee2Dto;
import com.example.springboot.entities.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface EmployeeMapper {
    public Boolean addEmp(Employee2 employee);

    Collection<Employee2Dto> findEmp();

    Collection<Department2> findDept();

    Employee2 findEmp2(Integer id);

    void editEmp(Employee2 employee2);

    void deleteEmp(Integer id);
}
