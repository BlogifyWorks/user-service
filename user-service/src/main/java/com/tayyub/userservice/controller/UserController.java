package com.tayyub.userservice.controller;


import com.tayyub.userservice.dto.UserDTO;
import com.tayyub.userservice.entity.User;
import com.tayyub.userservice.repository.UserRepository;
import com.tayyub.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public UserDTO createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }



}
