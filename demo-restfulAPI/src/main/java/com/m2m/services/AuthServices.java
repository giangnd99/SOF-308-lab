package com.m2m.services;

import com.m2m.dto.request.LoginRequest;
import com.m2m.dto.request.RegisterRequest;
import com.m2m.dto.response.AuthResponse;

public interface AuthServices {

    AuthResponse login(LoginRequest loginRequest);

    String register(RegisterRequest registerRequest);
}
