package com.moshiur.userservice.service;

import com.moshiur.userservice.dto.UserDTO;
import com.moshiur.userservice.dto.UserRegistrationRequestDTO;
import com.moshiur.userservice.exception.ResourceNotFoundException;
import com.moshiur.userservice.mapper.UserMapper;
import com.moshiur.userservice.model.User;
import com.moshiur.userservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.encoder = encoder;
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return userMapper.toDto(user);
    }

    public UserDTO registerUser(UserRegistrationRequestDTO requestDTO) {
        User user = new User();
        user.setEmail(requestDTO.getEmail());
        user.setPhone(requestDTO.getPhone());
        String hashedPassword = encoder.encode(requestDTO.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return userMapper.toDto(user);
    }


    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }
}
