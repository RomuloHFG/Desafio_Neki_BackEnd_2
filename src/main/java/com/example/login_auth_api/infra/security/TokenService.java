package com.example.login_auth_api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.login_auth_api.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.web.OffsetScrollPositionHandlerMethodArgumentResolver;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    private final OffsetScrollPositionHandlerMethodArgumentResolver offsetResolver;
    @Value("${api.security.token.secret}")
    private String secret;

    public TokenService(OffsetScrollPositionHandlerMethodArgumentResolver offsetResolver) {
        this.offsetResolver = offsetResolver;
    }

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("login-auth-api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(this.generateExpirationDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error while authenticating");
        }
    }

    public  String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("login-auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            return null;
        }
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.ofHours(-3));
    }

}

//O TokenService desempenha um papel crucial na segurança da sua aplicação Spring Boot ao fornecer
//um método seguro e eficaz para autenticar usuários usando tokens JWT.
//Ele garante que apenas usuários autenticados e autorizados possam acessar recursos protegidos pela aplicação,
//mantendo a integridade e a segurança dos dados.
