package com.ra.service;

import com.ra.entity.User;
import com.ra.exception.ResourceNotFoundException;
import com.ra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;


    public User create(User user) { return repository.save(user); }


    public User update(Long userId, User userDetails) throws ResourceNotFoundException {
        User user = findById(userId);

        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setInstituteName(userDetails.getInstituteName());
        user.setDescription(userDetails.getDescription());
        user.setAddress(userDetails.getAddress());
        User updatedUser = repository.save(user);

        return updatedUser;
    }


    public void delete(Long userId) throws ResourceNotFoundException {
        User user = findById(userId);
        repository.delete(user);
    }


    public User findById(Long userId) throws ResourceNotFoundException {
        return repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
    }


    public List<User> getList() {
        List<User> userList = repository.findAll();
        log.info("Found {} user(s) in DB", userList.size());
        return userList;
    }


}
