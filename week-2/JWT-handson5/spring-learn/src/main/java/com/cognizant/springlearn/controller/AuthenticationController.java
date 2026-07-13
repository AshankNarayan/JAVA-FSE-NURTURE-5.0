package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.security.JwtGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private JwtGenerator jwtGenerator;

    /**
     * REST endpoint to authenticate user credentials sent via Basic auth
     * and return a signed JSON Web Token (JWT).
     * URL: /authenticate
     */
    @GetMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticate(
            @RequestHeader(value = "Authorization", required = false) String authHeader) {
        
        LOGGER.info("START: authenticate() endpoint hit");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            LOGGER.warn("Missing or invalid Authorization header format.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        try {
            // Decode the credentials from 'Basic <Base64String>'
            String base64Credentials = authHeader.substring(6);
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedBytes);
            
            // Format of credentials string is "username:password"
            String[] values = credentials.split(":", 2);
            if (values.length == 2) {
                String username = values[0];
                String password = values[1];

                LOGGER.debug("Decoded credentials for username: {}", username);

                // Authenticate hardcoded user:pwd
                if ("user".equals(username) && "pwd".equals(password)) {
                    String token = jwtGenerator.generateToken(username);
                    Map<String, String> response = new HashMap<>();
                    response.put("token", token);
                    
                    LOGGER.info("END: authenticate() - Token successfully returned");
                    return ResponseEntity.ok(response);
                } else {
                    LOGGER.warn("Invalid username or password supplied.");
                }
            }
        } catch (Exception e) {
            LOGGER.error("Error occurred while decoding authorization header: ", e);
        }

        LOGGER.info("END: authenticate() - Unauthorized access attempt");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
