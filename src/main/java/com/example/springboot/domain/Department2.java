package com.example.springboot.domain;

public class Department2 {
    private Integer id;
    private String departmentName;

    public Department2() {
    }

    public Department2(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
