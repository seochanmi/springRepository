package com.example.boot12.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.boot12.util.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//요청할때마다 한번 거치는 필터 만들기 (스프링 프레임워크 내에서 동작하는 필터) 
@Component
public class JwtFilter extends OncePerRequestFilter{

	//jwt 를 쿠키로 저장할때 쿠키의 이름
	@Value("${jwt.name}")
	private String jwtName;
	//JwtUtil 객체 주입 받기
	@Autowired
	private JWTUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//1. 쿠키에서 JWT  토큰 추출
		Cookie[] cookies = request.getCookies();
		
		String jwtToken = "";
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if(jwtName.equals(cookie.getName())) {
					jwtToken = cookie.getValue();
					break;
				}
			}
		}
		//2. 토큰에서 userName 을 얻어내서
		
		//3. DB 에서 UserDetails 객체를 얻어낸다음
		
		//4. 토큰이 유효한 토큰인지 체크한 다음
		
		//5. 유효하다면 1회성 로그인(spring security 를 통과할 로그인)
		
	}

}
