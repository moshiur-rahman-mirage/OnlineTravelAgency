package com.moshiur.userservice.mapper;

import com.moshiur.userservice.dto.UserDTO;
import com.moshiur.userservice.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component

public class UserMapper {

    public UserDTO toDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        return dto;
    }

    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        return user;
    }
}

