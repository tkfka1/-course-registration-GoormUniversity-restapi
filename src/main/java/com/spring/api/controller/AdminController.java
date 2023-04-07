package com.spring.api.controller;

import com.spring.api.config.AppConfigAdmin;
import com.spring.api.request.AdminEdit;
import com.spring.api.request.AdminLogin;
import com.spring.api.request.AdminSearch;
import com.spring.api.request.AdminSignup;
import com.spring.api.response.AdminResponse;
import com.spring.api.response.SessionResponse;
import com.spring.api.service.AdminService;
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
public class AdminController {

    // admin 로그인, 회원가입, 하는 컨트롤러

    private final AdminService adminService;
    private final AppConfigAdmin appConfigAdmin;


    // admin 로그인  "/admin/auth/login" post
    @PostMapping("/api/admin/auth/login")
    public SessionResponse login(@RequestBody AdminLogin adminLogin) {
        Long userId = adminService.signin(adminLogin);
        SecretKey key = Keys.hmacShaKeyFor(appConfigAdmin.getJwtKey());
        String jws = Jwts.builder()
                .setSubject(String.valueOf(userId))
                .signWith(key)
                .setIssuedAt(new Date())
                .compact();

        return new SessionResponse(jws, userId.intValue());
    }

    // admin 회원가입  "/admin/auth/signup" post
    @PostMapping("/api/admin/auth/signup")
    public void signup(@RequestBody AdminSignup adminSignup) {
        adminService.signup(adminSignup);
    }


    // 단일 정보 조회 "/admin/auth/{id}" get
    @GetMapping("/api/admin/auth/{id}")
    public AdminResponse get(@PathVariable Long id) {
        return adminService.get(id);
    }

    @GetMapping("/api/admin/auth")
    public List<AdminResponse> getList(@ModelAttribute AdminSearch adminSearch) {
        return adminService.getList(adminSearch);
    }

    @DeleteMapping("/api/admin/auth/{id}")
    public void delete(@PathVariable Long id) {
        adminService.delete(id);
    }

    // 비밀번호 입력 있을 시
    @PutMapping("/api/admin/auth/{id}")
    public void edit(@PathVariable Long id, @RequestBody @Valid AdminEdit request) {
        adminService.edit(id, request);
    }

    // 비밀번호 입력 없을 때
    @PatchMapping("/api/admin/auth/{id}")
    public void edit2(@PathVariable Long id, @RequestBody @Valid AdminEdit request) {
        adminService.edit2(id, request);
    }





}
