package com.ganeshgc.userservice.controller;

import com.ganeshgc.userservice.entities.User;
import com.ganeshgc.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private Logger LOGGER= LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users=userService.userList();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getUser(@PathVariable String id) {
       return ResponseEntity.ok(userService.getUserById(id));
    }



    //creating fall back method for circuit breaker
    public ResponseEntity<User> ratingHotelFallBack(@PathVariable String id, Exception e) {
        LOGGER.info("fallback is executed because service is down : "+e.getMessage());
        User user=User.builder()
                .email("dummy@gmail.com")
                .userName("dummy")
                .about("this user is created dummy because currently some service is down")
                .userId("982283r29")
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }
}
