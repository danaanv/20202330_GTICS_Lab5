package com.example._20202330_gtics_lab5.repositorys;

import com.example._20202330_gtics_lab5.entitys.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}