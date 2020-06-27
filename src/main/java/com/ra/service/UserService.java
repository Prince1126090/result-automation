package com.ra.service;

import com.ra.entity.User;
import com.ra.exception.ResourceNotFoundException;
import com.ra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User create(User user) {
        return repository.save(user);
    }

    public User update(Long userId, User userDetails) throws ResourceNotFoundException {
        User user = findById(userId);
        user.setContactNumber(userDetails.getContactNumber());
        user.setDateOfBirth(userDetails.getDateOfBirth());
        user.setEmail(userDetails.getEmail());
        user.setGender(userDetails.getGender());
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
        List<User> userList;
        userList = repository.findAll();
        if (userList == null || userList.isEmpty()) {
            createSampleUsers();
            userList = repository.findAll();
        }
        return userList;
    }

    private void createSampleUsers() {
//        User userOne = new User();
//        userOne.setContactNumber("01781024196");
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        String dateInString = "05/01/1995";
//        Date date = null;
//        try {
//            date = formatter.parse(dateInString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        userOne.setDateOfBirth(date);
//        userOne.setEmail("prince1126090@gmail.com");
//        userOne.setGender(Gender.MALE);
//        create(userOne);
//
//        User userTwo = new User();
//        userTwo.setContactNumber("01781024188");
//        dateInString = "15/05/1996";
//        try {
//            date = formatter.parse(dateInString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        userTwo.setDateOfBirth(date);
//        userTwo.setEmail("abir@abcd.com");
//        userTwo.setGender(Gender.MALE);
//        create(userTwo);
    }

}
