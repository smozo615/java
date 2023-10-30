package com.taxi.taxi.controllers.auth.config.jwt;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtUtil {
    private static String SECRET = "secret";
    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);

    public String create(String email) {
        String token = JWT.create()
                .withSubject(email)
                .withIssuer(email)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1)))
                .sign(ALGORITHM);

        return token;
    }
}
