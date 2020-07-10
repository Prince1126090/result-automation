package com.ra.repository;

import com.ra.entity.StudentPerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPerformanceRepository extends JpaRepository<StudentPerformance, Long> {

}
