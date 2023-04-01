package com.spring.api.controller;


import com.spring.api.request.*;
import com.spring.api.response.TakeLectureResponse;
import com.spring.api.service.TakeLectureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TakeLectureController {

    // 수강 crud 컨트롤러

    private final TakeLectureService takeLectureService;

    // 수강 등록  "/take/auth/signup" post
    @PostMapping("/api/take/auth/signup")
    public void signup(@RequestBody TakeLectureSignup takeLectureSignup) {
        takeLectureService.signup(takeLectureSignup);
    }


    // 단일 수강 조회 "/take/auth/{id}" get
    @GetMapping("/api/take/auth/{id}")
    public TakeLectureResponse get(@PathVariable Long id) {
        return takeLectureService.get(id);
    }

    // 전체 수강 조회 "/take/auth/{id}" get
    @GetMapping("/api/take/auth")
    public List<TakeLectureResponse> getList(@ModelAttribute TakeLectureSearch takeLectureSearch) {
        return takeLectureService.getList(takeLectureSearch);
    }

    // 단일 수강 삭제 "/take/auth/{id}" get
    @DeleteMapping("/api/take/auth/{id}")
    public void delete(@PathVariable Long id) {
        takeLectureService.delete(id);
    }

    // 비밀번호 입력 있을 시
    @PutMapping("/api/take/auth/{id}")
    public void edit(@PathVariable Long id, @RequestBody @Valid TakeLectureEdit request) {
        takeLectureService.edit(id, request);
    }

    // 비밀번호 입력 없을 때
    @PatchMapping("/api/take/auth/{id}")
    public void edit2(@PathVariable Long id, @RequestBody @Valid TakeLectureEdit request) {
        takeLectureService.edit2(id, request);
    }


}
