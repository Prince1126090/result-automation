package com.ra.repository;

import com.ra.entity.StudentPerformance;
import com.ra.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentPerformanceRepository extends JpaRepository<StudentPerformance, Long> {

    List<StudentPerformance> findByYearAndStudentClassAndSectionAndExam(Integer year,
                                                                        Integer studentClass,
                                                                        String section,
                                                                        String exam);

    Optional<StudentPerformance> findByYearAndStudentClassAndSectionAndExamAndRoll(Integer year,
                                                                                   Integer studentClass,
                                                                                   String section,
                                                                                   String exam,
                                                                                   Integer roll);

}
