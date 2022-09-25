package com.ms.employeedemo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;
}
