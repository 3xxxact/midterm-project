package com.example.midterm;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private String salary;

    @Column(name = "age")
    private String age;

    @Override
    public String toString() {
        return "Employee{" +
                "employee=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
