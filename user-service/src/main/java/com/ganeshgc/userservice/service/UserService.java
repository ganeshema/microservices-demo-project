package com.ganeshgc.userservice.service;

import com.ganeshgc.userservice.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User getUserById(String id);
    List<User> userList();
    User saveUser(User user);
    User updateUser(String id, User user);
    void deleteUser(String id);
}
