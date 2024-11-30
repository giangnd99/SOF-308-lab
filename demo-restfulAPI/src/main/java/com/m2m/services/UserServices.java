package com.m2m.services;

import com.m2m.entity.User;

public interface UserServices {

    User save(User userRequest);

    User getUserById(Long id);

    User getUserByEmail(String email);

    User updateUser(Long id,User userRequest);

    void createAdminUser();
}
