package com.example._20202330_gtics_lab5.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department{
    @Id
    @Column(name = "department_id", nullable = false)
    private Integer id;

    @Column(name = "department_name", nullable = false, length = 30)
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

}
