package com.example.spring.controller;

import com.example.spring.model.User;
import com.example.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminRestController {
    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> usersList = userService.getAllUsers();
        if (usersList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        if (userService.addUser(user)) {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(user,HttpStatus.CONFLICT);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (userService.updateUser(user)) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable long id) {
        if (userService.deleteUserById(id)) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
    }
}