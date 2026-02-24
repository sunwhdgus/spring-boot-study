package com.backend.study.hellospring.global.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 1. 요청 헤더에서 "Authorization" 티켓 꺼내기
        String header = request.getHeader("Authorization");
        String token = null;

        // 2. 티켓이 "Bearer "로 시작하는지 확인하고, 진짜 토큰 부분만 자르기
        if (header != null && header.startsWith("Bearer ")) {
            token = header.substring(7);
        }

        // 3. 토큰이 존재하고, jwtUtil에서 감정이 끝나면
        if (token != null && jwtUtil.validateToken(token)) {

            // 4. 토큰에서 유저 이름(ID) 꺼내기
            String username = jwtUtil.getUsernameFromToken(token);

            // 5. 시큐리티 명단에 등록
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        // 6. 검사 끝났으니 다음 문지기(필터)에게 전달
        filterChain.doFilter(request, response);
    }
}
