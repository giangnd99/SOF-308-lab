package com.m2m.services.impl;


import com.m2m.dto.request.LoginRequest;
import com.m2m.dto.request.RegisterRequest;
import com.m2m.dto.response.AuthResponse;
import com.m2m.entity.User;
import com.m2m.exception.ValidationException;
import com.m2m.repo.UserRepo;
import com.m2m.services.AuthServices;
import com.m2m.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServicesImpl implements AuthServices {

    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoderUtil;

    @Autowired
    public AuthServicesImpl(AuthenticationManager authenticationManager,
                            UserRepo userRepository,
                            JwtTokenProvider jwtTokenProvider,
                            PasswordEncoder passwordEncoderUtil) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoderUtil = passwordEncoderUtil;
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        String token = jwtTokenProvider.generateToken(authentication);
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
        return new AuthResponse(token, loginRequest.getEmail(), isAdmin);
    }

    @Override
    public String register(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new ValidationException("Email đã được đăng ký.");
        }

        User user = new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoderUtil.encode(registerRequest.getPassword()));
        user.setIsAdmin(registerRequest.getAdmin());
        userRepository.save(user);

        return "Đăng ký thành công.";
    }
}
