package com.backend.study.hellospring.global.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // 1. 위조 방지용 비밀키 (32글자 이상)
    // 실제로는 이렇게 쓰지 않고 application.yml 파일에 숨김
    private final String secret = "my-super-secret-key-for-jwt-study-spring-boot";
    private final Key key = Keys.hmacShaKeyFor(secret.getBytes());

    // 2. 토큰 유효시간 (예: 1시간 = 1000ms * 60 * 60)
    private final  long expirationTime = 1000 * 60 * 60;

    // 3. 토큰 발급기 (로그인 성공 시 호출)
    public String createToken(String username) {
        return Jwts.builder()
                .setSubject(username) // 토큰의 주인(ID) 기록
                .setIssuedAt(new Date()) // 발급 시간 기록
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // 만료 시간 세팅
                .signWith(key, SignatureAlgorithm.HS256) // 비밀키로 위조 방지
                .compact(); // 최종적으로 긴 문자열(토큰)로 압축해서 반환
    }

    // 4. 토큰 감정사 (클라이언트가 토큰을 들고 왔을 때 진짜인지 확인)
    public boolean validateToken(String token) {
        try {
            // 우리가 가진 비밀키로 열어봤을 때 에러가 안 나면 진짜 토큰
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // 유효기간이 지났거나, 해커가 글자 하나라도 조작했으면 바로 에러 발생
            return false;
        }
    }

    // 5. 토큰에서 유저 이름(ID)만 빼오는 기능
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
