//package com.example.ecommerce.utills;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//
//    private static final String secretKey = "LKjhh";
//
//    private long validityInMilliseconds = 3600000; // 1 hour
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
//                .signWith(SignatureAlgorithm.HS256, secretKey)
//                .compact();
//    }
//
//    public boolean validateToken(String token, String username) {
//        final String extractedUsername = extractUsername(token);
//        return (extractedUsername.equals(username) && !isTokenExpired(token));
//    }
//
//    public String extractUsername(String token) {
//        return getAllClaimsFromToken(token).getSubject();
//    }
//
//    private Claims getAllClaimsFromToken(String token) {
//      return (Claims) Jwts.parser().setSigningKey(token).build().parseClaimsJws(token);
//
//    }
//
//
//    private boolean isTokenExpired(String token) {
//        return getAllClaimsFromToken(token).getExpiration().before(new Date());
//    }
//}
