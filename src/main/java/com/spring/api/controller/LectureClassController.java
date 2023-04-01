package com.spring.api.controller;


import com.spring.api.request.*;
import com.spring.api.response.LectureClassResponse;
import com.spring.api.service.LectureClassService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LectureClassController {

    // 강의 crud 컨트롤러
    private final LectureClassService lectureClassService;

    // 강의 회원가입  "/lecture/auth/signup" post
    @PostMapping("/api/lectureClass/auth/signup")
    public void signup(@RequestBody LectureClassSignup lectureClassSignup) {
        lectureClassService.signup(lectureClassSignup);
    }

    // 단일 정보 조회 "/lectureClass/auth/{id}" get
    @GetMapping("/api/lectureClass/auth/{id}")
    public LectureClassResponse get(@PathVariable Long id) {
        return lectureClassService.get(id);
    }

    // 전체 정보 조회 "/lectureClass/auth/{id}" get
    @GetMapping("/api/lectureClass/auth")
    public List<LectureClassResponse> getList(@ModelAttribute LectureClassSearch lectureClassSearch) {
        return lectureClassService.getList(lectureClassSearch);
    }

    // 단일 정보 삭제 "/lectureClass/auth/{id}" get
    @DeleteMapping("/api/lectureClass/auth/{id}")
    public void delete(@PathVariable Long id) {
        lectureClassService.delete(id);
    }

    // 비밀번호 입력 있을 시
    @PutMapping("/api/lectureClass/auth/{id}")
    public void edit(@PathVariable Long id, @RequestBody @Valid LectureClassEdit request) {
        lectureClassService.edit(id, request);
    }

    // 비밀번호 입력 없을 때
    @PatchMapping("/api/lectureClass/auth/{id}")
    public void edit2(@PathVariable Long id, @RequestBody @Valid LectureClassEdit request) {
        lectureClassService.edit2(id, request);
    }


}
