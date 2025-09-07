package org.example.bookmyshow.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.example.bookmyshow.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JWTUtils {


    @Value("${jwt.secret}" )
    private String secretKey;

    @Value("${jwt.expiration}")
    private long jwtExpirationInMs;


    public String generateToken(User user){
         SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder().issuedAt(new Date()).expiration( new Date(System.currentTimeMillis() + jwtExpirationInMs)).claims(putClaims(user)).signWith(key).compact();
    }

    /**
     * Generates a JWT token for the given user.
     *
     * @param user the user for whom the token is generated
     * @return a JWT token as a String
     */

    private Map<String, Object> putClaims(User user) {
        return Map.of(
                "id", user.getId(),
                "email", user.getEmail(),
                "name", user.getName(),
                "userType",user.getUserType().name());
    }

    public boolean validateToken(String token){
        try {
            SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
            Jws<Claims> claims =Jwts.parser().setSigningKey(key).build().parseClaimsJws(token);

            return true;
        }catch (Exception e){
            return false;
        }
    }

}
