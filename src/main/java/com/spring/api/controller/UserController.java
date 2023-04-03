package com.spring.api.controller;

import com.spring.api.config.AppConfigUser;
import com.spring.api.request.*;
import com.spring.api.response.SessionResponse;
import com.spring.api.response.UserResponse;
import com.spring.api.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    // 학생 로그인, 회원가입, 하는 컨트롤러

    private final UserService userService;
    private final AppConfigUser appConfigUser;

    // 학생 로그인  "/admin/auth/login" post
    @PostMapping("/api/user/auth/login")
    public SessionResponse login(@RequestBody UserLogin userLogin) {
        Long userId = userService.signin(userLogin);

        SecretKey key = Keys.hmacShaKeyFor(appConfigUser.getJwtKey());

        String jws = Jwts.builder()
                .setSubject(String.valueOf(userId))
                .signWith(key)
                .setIssuedAt(new Date())
                .compact();

        return new SessionResponse(jws, userId.intValue());
    }

    // 학생 회원가입  "/admin/auth/signup" post
    @PostMapping("/api/user/auth/signup")
    public void signup(@RequestBody UserSignup userSignup) {
        userService.signup(userSignup);
    }


    // 단일 정보 조회 "/admin/auth/{id}" get
    @GetMapping("/api/user/auth/{id}")
    public UserResponse get(@PathVariable Long id) {
        return userService.get(id);
    }

    // 전체 정보 조회 "/admin/auth/{id}" get
    @GetMapping("/api/user/auth")
    public List<UserResponse> getList(@ModelAttribute UserSearch userSearch) {
        return userService.getList(userSearch);
    }

    // 단일 정보 삭제 "/admin/auth/{id}" get
    @DeleteMapping("/api/user/auth/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    // 비밀번호 입력 있을 시
    @PutMapping("/api/user/auth/{id}")
    public void edit(@PathVariable Long id, @RequestBody @Valid UserEdit request) {
        userService.edit(id, request);
    }

    // 비밀번호 입력 없을 때
    @PatchMapping("/api/user/auth/{id}")
    public void edit2(@PathVariable Long id, @RequestBody @Valid UserEdit request) {
        userService.edit2(id, request);
    }

}
