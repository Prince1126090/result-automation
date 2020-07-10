package com.ra.controller;

import com.ra.dto.UserCredentials;
import com.ra.entity.StudentPerformance;
import com.ra.entity.User;
import com.ra.exception.ResourceNotFoundException;
import com.ra.service.StudentPerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentPerformanceController {

    private final StudentPerformanceService service;

    @GetMapping("/performance")
    public List<StudentPerformance> getAllPerformance() {
        return service.getList();
    }

//    @GetMapping("/users/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
//            throws ResourceNotFoundException {
//        User user = service.findById(userId);
//        return ResponseEntity.ok().body(user);
//    }

    @PostMapping("/performance")
    public StudentPerformance createPerformance(@Valid @RequestBody StudentPerformance performance) {
        return service.create(performance);
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
