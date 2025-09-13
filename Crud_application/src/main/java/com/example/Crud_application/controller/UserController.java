package com.example.Crud_application.controller;

import com.example.Crud_application.dto.UserDTO;
import com.example.Crud_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/users/")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @PostMapping("/login")
    public UserDTO loginUser(@RequestBody UserDTO userDTO) {
        UserDTO authenticatedUser = userService.loginUser(userDTO.getEmail(), userDTO.getPassword());
        if (authenticatedUser != null) {
            return authenticatedUser;
        } else {
            return null;
        }
    }

    @GetMapping("/getdetails/{email}")
    public UserDTO getUserByEmail(@PathVariable String email) {
        UserDTO userDTO = userService.getUserByEmail(email);
        if (userDTO != null) {
            return userDTO;
        } else {
            return null;
        }
    }

    @PutMapping("/updateuser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(userDTO);
        if (updatedUser != null) {
            return updatedUser;
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{email}")
    public String deleteUser(@PathVariable String email) {
        boolean isDeleted = userService.deleteUser(email);
        if (isDeleted) {
            return "user deleted successfully";
        } else {
            return "error";
        }
    }

}
