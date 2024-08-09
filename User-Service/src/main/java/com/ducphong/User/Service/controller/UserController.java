package com.ducphong.User.Service.controller;

import com.ducphong.User.Service.model.User;
import com.ducphong.User.Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResponseEntity<?> createStudent(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<?> fetchStudentById(@PathVariable String id){
        return userService.fetchUserById(id);
    }
    @GetMapping("/api/user")
    public ResponseEntity<?> fetchStudents(){
        return userService.fetchUsers();
    }
}
