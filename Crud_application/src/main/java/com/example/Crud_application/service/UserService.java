package com.example.Crud_application.service;

import com.example.Crud_application.dto.UserDTO;
import com.example.Crud_application.model.User;
import com.example.Crud_application.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO) {
        User existingUser = userRepo.findByEmail(userDTO.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("User with this email already exists.");
        }
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public UserDTO loginUser(String email, String password) {
        User user = userRepo.findByEmailAndPassword(email, password);
        if (user != null) {
            return modelMapper.map(user, UserDTO.class);
        } else {
            return null;
        }
    }

    public UserDTO getUserByEmail(String email) {
        User user = userRepo.findByEmail(email);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        User user = userRepo.findByEmail(userDTO.getEmail());
        if (user != null) {
            user.setName(userDTO.getName());
            user.setPassword(userDTO.getPassword());
            user.setAge(userDTO.getAge());
            user.setCountry(userDTO.getCountry());
            user.setInterest(userDTO.getInterest());
            userRepo.save(user);
            return modelMapper.map(user, UserDTO.class);
        } else {
            return null;
        }
    }

    public boolean deleteUser(String email) {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            userRepo.delete(user);
            return true;
        } else {
            return false;
        }
    }

}
