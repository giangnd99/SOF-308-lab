package com.m2m.controller;

import com.m2m.entity.User;
import com.m2m.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServices userService;

    @Autowired
    public UserController(UserServices userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public User getUserInfoByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PutMapping("/{id}")
    public User updateUserInfo(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @PostMapping("/create-admin")
    public String createAdmin() {
        try {
            userService.createAdminUser();
            return "Admin user created successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occurred while creating admin user.";
        }
    }
}