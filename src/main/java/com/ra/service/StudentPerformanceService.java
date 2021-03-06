package com.ra.service;

import com.ra.dto.SearchPerformance;
import com.ra.entity.Mark;
import com.ra.entity.StudentPerformance;
import com.ra.exception.ResourceNotFoundException;
import com.ra.repository.StudentPerformanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentPerformanceService {

    private final StudentPerformanceRepository repository;


    public List<StudentPerformance> findExamPerformance(SearchPerformance searchParams) {
        return repository.findByYearAndStudentClassAndSectionAndExam(
                searchParams.getYear(),
                searchParams.getStudentClass(),
                searchParams.getSection(),
                searchParams.getExam()
        );
    }

    public StudentPerformance findIndividualPerformance(SearchPerformance searchParams) throws ResourceNotFoundException {
        return repository.findByYearAndStudentClassAndSectionAndExamAndRoll(
                searchParams.getYear(),
                searchParams.getStudentClass(),
                searchParams.getSection(),
                searchParams.getExam(),
                searchParams.getRoll()
        ).orElseThrow(() -> new ResourceNotFoundException("User not Found"));
    }


    public StudentPerformance create(StudentPerformance reqPerformance) {
        StudentPerformance performance = new StudentPerformance();
        performance.setYear(reqPerformance.getYear());
        performance.setStudentClass(reqPerformance.getStudentClass());
        performance.setSection(reqPerformance.getSection());
        performance.setRoll(reqPerformance.getRoll());
        performance.setExam(reqPerformance.getExam());
        performance.setOtherInfo(reqPerformance.getOtherInfo());

        List<Mark> marks = new ArrayList<>();
        for(Mark reqMark: reqPerformance.getMarks()){
            Mark mark = new Mark();
            mark.setStudentPerformance(performance);
            mark.setSubjectName(reqMark.getSubjectName());
            mark.setTotalMark(reqMark.getTotalMark());
            mark.setObtainedMark(reqMark.getObtainedMark());
            marks.add(mark);
        }
        performance.setMarks(marks);

        return repository.save(performance);
    }


    public StudentPerformance update(Long performanceId, StudentPerformance performanceDetails) throws ResourceNotFoundException {
        StudentPerformance performance = findById(performanceId);

//        user.setPassword(userDetails.getPassword());
//        user.setEmail(userDetails.getEmail());
//        user.setInstituteName(userDetails.getInstituteName());
//        user.setDescription(userDetails.getDescription());
//        user.setAddress(userDetails.getAddress());
        StudentPerformance updatedPerformance = repository.save(performance);

        return updatedPerformance;
    }


    public void delete(Long performanceId) throws ResourceNotFoundException {
        StudentPerformance performance = findById(performanceId);
        repository.delete(performance);
    }


    public StudentPerformance findById(Long performanceId) throws ResourceNotFoundException {
        return repository.findById(performanceId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + performanceId));
    }


    public List<StudentPerformance> getList() {
        List<StudentPerformance> performanceList = repository.findAll();
        log.info("Found {} performance(s) in DB", performanceList.size());
        return performanceList;
    }


}
