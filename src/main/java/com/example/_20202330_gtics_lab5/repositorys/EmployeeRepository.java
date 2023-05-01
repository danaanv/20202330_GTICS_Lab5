package com.example._20202330_gtics_lab5.repositorys;

import com.example._20202330_gtics_lab5.entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(nativeQuery = true, value = "SELECT e.* from employees e \n" +
            "inner join jobs j on e.job_id=j.job_id\n" +
            "inner join departments d on e.department_id=d.department_id \n" +
            "inner join locations l on d.location_id=l.location_id\n" +
            "where ((e.first_name like %?1%) or (e.last_name like %?1%) or (j.job_title like %?1%) or (d.department_name like %?1%) or (l.city like %?1%))")
    List<Employee> buscadorDeListaEmployees(String texto);

    @Transactional
    @Modifying
    @Query(value = "insert into employees (`first_name`, `last_name`, `email`, `password`, `job_id`,`salary`, `manager_id`, `department_id`,`enabled` ) values (?1,?2,?3,?4,?5,?6,?7,?8,1) ",
            nativeQuery = true)
    void guardarEmpleado(String nombre, String apellido, String email, String password, String job_id, double sueldo, int jefe_id, int departamento_id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE employees SET enabled = 0 where employee_id = ?1", nativeQuery = true)
    void borrarEmpleado(int employee_id);

    @Query(nativeQuery = true, value = "select * from employees where enabled=1")
    List<Employee> listarEnables();
}