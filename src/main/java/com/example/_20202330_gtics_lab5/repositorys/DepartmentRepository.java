package com.example._20202330_gtics_lab5.repositorys;

import com.example._20202330_gtics_lab5.entitys.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(value = "select * from departments where department_name = ?1",
            nativeQuery = true)
    List<Department> findByDepartmentName(String nombre);

}