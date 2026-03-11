package com.S.B.Project.springbootrestapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;
    private String location;

    // ----- GETTERS -----
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getLocation() {
        return location;
    }

    // ----- SETTERS -----
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}