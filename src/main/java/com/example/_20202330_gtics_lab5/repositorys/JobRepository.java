package com.example._20202330_gtics_lab5.repositorys;

import com.example._20202330_gtics_lab5.dtos.ReporteDto;
import com.example._20202330_gtics_lab5.entitys.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface JobRepository extends JpaRepository<Job, String> {

    @Query(nativeQuery = true,
            value = "SELECT job_title as puestonombre, min(e.salary) as salminimo,\n" +
                    "max(e.salary) as salmaximo, sum(e.salary) as saltotal,\n" +
                    "truncate(avg(e.salary),2) as salpromedio\n" +
                    "from hr.jobs j INNER JOIN hr.employees e on (e.job_id=j.job_id) \n" +
                    "group by j.job_title order by puestonombre;")
    List<ReporteDto> jobsDtoForReporte();
}