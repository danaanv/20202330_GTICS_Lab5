package com.example._20202330_gtics_lab5.repositorys;

import com.example._20202330_gtics_lab5.entitys.JobHistory;
import com.example._20202330_gtics_lab5.entitys.JobHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {
}