package com.m2m.services.impl;

import com.m2m.entity.User;
import com.m2m.repo.UserRepo;
import com.m2m.services.UserServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {

    private final PasswordEncoder bcrypt;
    private final UserRepo userRepo;

    @Autowired
    public UserServicesImpl(UserRepo userRepo, PasswordEncoder bcrypt) {
        this.bcrypt = bcrypt;
        this.userRepo = userRepo;
    }

    @Override
    @Transactional(rollbackOn = Throwable.class)
    public User save(User userRequest) {
        if (userRequest == null || userRequest.getPassword() == null || userRequest.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password is required.");
        }
        userRequest.setPassword(bcrypt.encode(userRequest.getPassword()));
        return userRepo.saveAndFlush(userRequest);
    }

    @Override
    public User getUserById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid user ID.");
        }

        return userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
    }

    @Override
    public User getUserByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Invalid email");
        }
        return userRepo.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));
    }

    @Override
    @Transactional(rollbackOn = Throwable.class)
    public User updateUser(Long id, User userRequest) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid user ID.");
        }
        User existingUser = getUserById(id);
        if (userRequest.getName() != null && !userRequest.getName().isEmpty()) {
            existingUser.setName(userRequest.getName());
        }
        if (userRequest.getEmail() != null && !userRequest.getEmail().isEmpty()) {
            existingUser.setEmail(userRequest.getEmail());
        }
        if (userRequest.getPassword() != null && !userRequest.getPassword().isEmpty()) {
            if (!userRequest.getPassword().equals(existingUser.getPassword())) {
                existingUser.setPassword(bcrypt.encode(userRequest.getPassword()));
            }
        }
        if (userRequest.getAvatar() != null && !userRequest.getAvatar().isEmpty()) {
            existingUser.setAvatar(userRequest.getAvatar());
        }
        return userRepo.save(existingUser);
    }

    @Transactional(rollbackOn = Throwable.class)
    @Override
    public void createAdminUser() {
        String encodedPassword = bcrypt.encode("123");
        User admin = new User();
        admin.setPassword(encodedPassword);
        admin.setName("admin");
        admin.setEmail("admin@gmail.com");
        admin.setIsAdmin(true);
        userRepo.save(admin);
    }
}
