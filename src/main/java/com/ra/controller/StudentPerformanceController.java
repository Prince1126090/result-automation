package com.ra.controller;

import com.ra.dto.SearchPerformance;
import com.ra.entity.StudentPerformance;
import com.ra.exception.ResourceNotFoundException;
import com.ra.service.StudentPerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentPerformanceController {

    private final StudentPerformanceService service;

    @GetMapping("/performance")
    public List<StudentPerformance> getAllPerformance() {
        return service.getList();
    }

    @PostMapping("/performance")
    public StudentPerformance createPerformance(@Valid @RequestBody StudentPerformance performance) {
        return service.create(performance);
    }

    @PostMapping("/exam-performance")
    public List<StudentPerformance> findPerformance(@Valid @RequestBody SearchPerformance searchPerformance) {
        return service.findExamPerformance(searchPerformance);
    }

    @PostMapping("/individual-performance")
    public StudentPerformance findIndividualPerformance(@Valid @RequestBody SearchPerformance searchPerformance) throws ResourceNotFoundException {
        return service.findIndividualPerformance(searchPerformance);
    }

//    @PutMapping("/users/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
//                                           @Valid @RequestBody User employeeDetails) throws ResourceNotFoundException {
//        User updatedUser = service.update(userId, employeeDetails);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    @DeleteMapping("/users/{id}")
//    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
//            throws ResourceNotFoundException {
//        service.delete(userId);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

}
