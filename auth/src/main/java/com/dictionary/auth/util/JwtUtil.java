package com.dictionary.auth.util;

import com.dictionary.auth.user.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtUtil {

    @Autowired
    private UserService userService;

    @Value("secret")
    private String jwtSecret;

    private int expiresIn = 1000 * 60 * 180;  // 180 min = 1000ms = 1s * 60s = 1min * 180 = 3h

    public String generateToken(String email) {
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + expiresIn;
        Date exp = new Date(expMillis);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(nowMillis))
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public Boolean validateToken(String token) {
        final String email = getAllClaims(token).getSubject();
        log.info("email iz tokena je: {}", email);
        String userMail = userService.getUserByEmail(email).getEmail();

        return (email != null && email.equals(userMail) && !isTokenExpired(token));
    }

    public Claims getAllClaims(final String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    }

    public boolean isTokenExpired(String token) {
        final Date expiration = getAllClaims(token).getExpiration();
        return expiration.before(new Date());
    }

}
