package com.spring.api.controller;


import com.spring.api.request.*;
import com.spring.api.response.LectureResponse;
import com.spring.api.response.ProfessorResponse;
import com.spring.api.service.LectureService;
import com.spring.api.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LectureController {

    // 강의 crud 컨트롤러

    private final LectureService lectureService;

    // 강의 회원가입  "/lecture/auth/signup" post
    @PostMapping("/api/lecture/auth/signup")
    public void signup(@RequestBody LectureSignup lectureSignup) {
        lectureService.signup(lectureSignup);
    }


    // 단일 정보 조회 "/lecture/auth/{id}" get
    @GetMapping("/api/lecture/auth/{id}")
    public LectureResponse get(@PathVariable Long id) {
        return lectureService.get(id);
    }

    // 전체 정보 조회 "/lecture/auth/{id}" get
    @GetMapping("/api/lecture/auth")
    public List<LectureResponse> getList(@ModelAttribute LectureSearch lectureSearch) {
        return lectureService.getList(lectureSearch);
    }

    // 단일 정보 삭제 "/lecture/auth/{id}" get
    @DeleteMapping("/api/lecture/auth/{id}")
    public void delete(@PathVariable Long id) {
        lectureService.delete(id);
    }

    // 비밀번호 입력 있을 시
    @PutMapping("/api/lecture/auth/{id}")
    public void edit(@PathVariable Long id, @RequestBody @Valid LectureEdit request) {
        lectureService.edit(id, request);
    }

    // 비밀번호 입력 없을 때
    @PatchMapping("/api/lecture/auth/{id}")
    public void edit2(@PathVariable Long id, @RequestBody @Valid LectureEdit request) {
        lectureService.edit2(id, request);
    }



}
