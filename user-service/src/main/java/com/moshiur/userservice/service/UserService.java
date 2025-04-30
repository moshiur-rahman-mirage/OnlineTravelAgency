package com.moshiur.userservice.service;

import com.moshiur.userservice.dto.UserDTO;
import com.moshiur.userservice.dto.UserRegistrationRequestDTO;

public interface UserService {
    UserDTO getUserById(Long id);
    void deleteUser(Long id);
    UserDTO registerUser(UserRegistrationRequestDTO requestDTO);
}

