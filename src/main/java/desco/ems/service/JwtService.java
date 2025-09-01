// JwtService.java
package desco.ems.service;

import desco.ems.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired
    private JwtUtil jwtUtil;

    public String generateToken(UserDetails userDetails) {
        return jwtUtil.generateToken(userDetails);
    }

    public String extractUsername(String token) {
        return jwtUtil.extractUsername(token);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        return jwtUtil.validateToken(token, userDetails);
    }

    public Boolean isTokenValid(String token) {
        return jwtUtil.isTokenValid(token);
    }
}