package com.spring.api.controller;

import com.spring.api.request.*;
import com.spring.api.response.MajorResponse;
import com.spring.api.service.MajorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MajorController {

    // 전공 crud 컨트롤러

    private final MajorService majorService;

    // 전공 회원가입  "/major/auth/signup" post
    @PostMapping("/api/major/auth/signup")
    public void signup(@RequestBody MajorSignup majorSignup) {
        majorService.signup(majorSignup);
    }


    // 단일 정보 조회 "/major/auth/{id}" get
    @GetMapping("/api/major/auth/{id}")
    public MajorResponse get(@PathVariable Long id) {
        return majorService.get(id);
    }

    // 전체 정보 조회 "/major/auth/{id}" get
    @GetMapping("/api/major/auth")
    public List<MajorResponse> getList(@ModelAttribute MajorSearch majorSearch) {
        return majorService.getList(majorSearch);
    }

    // 단일 정보 삭제 "/major/auth/{id}" get
    @DeleteMapping("/api/major/auth/{id}")
    public void delete(@PathVariable Long id) {
        majorService.delete(id);
    }

    // 비밀번호 입력 있을 시
    @PutMapping("/api/major/auth/{id}")
    public void edit(@PathVariable Long id, @RequestBody @Valid MajorEdit request) {
        majorService.edit(id, request);
    }

    // 비밀번호 입력 없을 때
    @PatchMapping("/api/major/auth/{id}")
    public void edit2(@PathVariable Long id, @RequestBody @Valid MajorEdit request) {
        majorService.edit2(id, request);
    }



}
