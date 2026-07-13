package com.cognizant.springlearn.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtGenerator.class);
    
    // Secret key for signing the JWT (in production, load from config/vault)
    private static final String SECRET_KEY = "mySecretKeyForSigningJwtTokensWithHs256Algorithm";
    
    // 30 minutes expiration time (in milliseconds)
    private static final long EXPIRATION_TIME = 1800000;

    /**
     * Generates a signed HS256 JWT token for the given username.
     */
    public String generateToken(String username) {
        LOGGER.info("START: generateToken() for user: {}", username);
        
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date expiryDate = new Date(nowMillis + EXPIRATION_TIME);

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        LOGGER.info("END: generateToken() successfully created token");
        return token;
    }
}
