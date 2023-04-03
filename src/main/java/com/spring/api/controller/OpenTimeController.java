package com.spring.api.controller;


import com.spring.api.request.*;
import com.spring.api.response.OpenTimeResponse;

import com.spring.api.service.OpenTimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OpenTimeController {


    private final OpenTimeService openTimeService;


    // 시간 등록  "/api/time/auth/signup" post
    @PostMapping("/api/time/auth/signup")
    public void signup(@RequestBody OpenTimeSignup openTimeSignup) {
        openTimeService.signup(openTimeSignup);
    }


    // 단일 정보 조회 "/time/auth/{id}" get
    @GetMapping("/api/time/auth/{id}")
    public OpenTimeResponse get(@PathVariable Long id) {
        return openTimeService.get(id);
    }

    // 전체 정보 조회 "/time/auth/{id}" get
    @GetMapping("/api/time/auth")
    public List<OpenTimeResponse> getList(@ModelAttribute OpenTimeSearch openTimeSearch) {
        return openTimeService.getList(openTimeSearch);
    }

    // 단일 정보 삭제 "/time/auth/{id}" get
    @DeleteMapping("/api/time/auth/{id}")
    public void delete(@PathVariable Long id) {
        openTimeService.delete(id);
    }

    // 비밀번호 입력 있을 시
    @PutMapping("/api/time/auth/{id}")
    public void edit(@PathVariable Long id, @RequestBody @Valid OpenTimeEdit request) {
        openTimeService.edit(id, request);
    }

    // 비밀번호 입력 없을 때
    @PatchMapping("/api/time/auth/{id}")
    public void edit2(@PathVariable Long id, @RequestBody @Valid OpenTimeEdit request) {
        openTimeService.edit2(id, request);
    }

}
