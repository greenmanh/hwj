package com.example.springboot.controller;

import com.example.springboot.dao.DepartmentDao;
import com.example.springboot.dao.EmployeeDao;
import com.example.springboot.domain.Department2;
import com.example.springboot.domain.Employee2;
import com.example.springboot.dto.Employee2Dto;
import com.example.springboot.entities.Department;
import com.example.springboot.entities.Employee;
import com.example.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    EmployeeService employeeService;

    /**
     * 查询所有员工信息
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String findEmp(Model model){
        Collection<Employee2Dto> all=employeeService.findEmp();
        //Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "emp/list";
    }

    /**
     * 进入添加员工界面
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String toAddEmp(Model model){
        //刷新department内容
        //Collection<Department> departments = departmentDao.getDepartments();
        Collection<Department2> departments =employeeService.finDep();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee2 employee){
        employeeService.addEmp(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }

    /**
     * 进入员工修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditEmp(@PathVariable("id")Integer id,Model model){
        Collection<Department2> departments =employeeService.finDep();
        model.addAttribute("depts",departments);

        //Employee employee = employeeDao.get(id);
        Employee2 employee=employeeService.findEmp(id);
        System.out.println(employee);
        model.addAttribute("emp",employee);
        return "emp/add";
    }
    @PutMapping("/emp")
    public String editEmp(Employee2 employee2,Model model){
        Collection<Department2> departments =employeeService.finDep();
        model.addAttribute("depts",departments);
        employeeService.editEmp(employee2);
        return "redirect:/emps";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeService.deleteEmp(id);
        return "redirect:/emps";
    }
}
