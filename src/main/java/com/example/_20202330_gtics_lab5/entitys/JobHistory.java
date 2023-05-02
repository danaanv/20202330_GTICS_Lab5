package com.example._20202330_gtics_lab5.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "job_history")
public class JobHistory {
    @EmbeddedId
    private JobHistoryId id;

    @MapsId("employeeId")
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "end_date", nullable = false)
    private Instant endDate;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
