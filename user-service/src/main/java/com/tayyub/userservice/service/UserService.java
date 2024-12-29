package com.tayyub.userservice.service;

import com.tayyub.userservice.dto.UserDTO;
import com.tayyub.userservice.entity.User;
import com.tayyub.userservice.repository.UserRepository;
import com.tayyub.userservice.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::toUserDTO).collect(Collectors.toList());
    }

    public UserDTO createUser(User user) {
        User savedUser= userRepository.save(user);
        return UserMapper.toUserDTO(savedUser);
    }

    public UserDTO getUserById(Long id) {
        User user= userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        return UserMapper.toUserDTO(user);
    }
}
