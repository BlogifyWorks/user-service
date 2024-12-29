package com.tayyub.userservice.util;

import com.tayyub.userservice.dto.UserDTO;
import com.tayyub.userservice.entity.User;

public class UserMapper {
    public static UserDTO toUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getBio()
        );
    }
}
