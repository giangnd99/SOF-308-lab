package com.m2m.util;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.text.ParseException;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[{]}|;:,.<>?/";

    private String secretKey = generateSecretKey(32);

    @Value("${jwt.expiration}")
    private long validityInMilliseconds;

    public String generateToken(Authentication authentication) {

        boolean isAdmin = authentication.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .subject(authentication.getName())
                .issuer("blog-app")
                .issueTime(new Date())
                .claim("isAdmin", isAdmin)
                .expirationTime(new Date(System.currentTimeMillis() + validityInMilliseconds))
                .build();

        SignedJWT signedJWT = new SignedJWT(
                new JWSHeader(JWSAlgorithm.HS256),
                claims
        );

        try {
            signedJWT.sign(new MACSigner(secretKey));
        } catch (JOSEException e) {
            throw new RuntimeException("Error signing JWT token", e);
        }

        return signedJWT.serialize();
    }

    public boolean validateToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWTClaimsSet claims = signedJWT.getJWTClaimsSet();

            if (claims.getExpirationTime().before(new Date())) {
                return false;
            }
            return true;
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing JWT token", e);
        }
    }

    public String getEmailFromToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWTClaimsSet claims = signedJWT.getJWTClaimsSet();
            return claims.getSubject();
        } catch (ParseException e) {
            throw new RuntimeException("Error extracting username from JWT", e);
        }
    }

    public boolean isAdmin(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWTClaimsSet claims = signedJWT.getJWTClaimsSet();

            return claims.getBooleanClaim("isAdmin");
        } catch (ParseException e) {
            throw new RuntimeException("Invalid JWT token", e);
        }
    }

    public static String generateSecretKey(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder secretKey = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            secretKey.append(CHARACTERS.charAt(index));
        }
        return secretKey.toString();
    }
}