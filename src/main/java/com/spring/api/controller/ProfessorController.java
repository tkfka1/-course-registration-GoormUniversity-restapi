package com.spring.api.controller;


import com.spring.api.request.ProfessorEdit;
import com.spring.api.request.ProfessorSearch;
import com.spring.api.request.ProfessorSignup;
import com.spring.api.response.ProfessorResponse;
import com.spring.api.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProfessorController {

    // 교수 crud 컨트롤러

    private final ProfessorService professorService;

    // 교수 회원가입  "/professor/auth/signup" post
    @PostMapping("/api/professor/auth/signup")
    public void signup(@RequestBody ProfessorSignup professorSignup) {
        professorService.signup(professorSignup);
    }


    // 단일 정보 조회 "/professor/auth/{id}" get
    @GetMapping("/api/professor/auth/{id}")
    public ProfessorResponse get(@PathVariable Long id) {
        return professorService.get(id);
    }

    // 전체 정보 조회 "/professor/auth/{id}" get
    @GetMapping("/api/professor/auth")
    public List<ProfessorResponse> getList(@ModelAttribute ProfessorSearch professorSearch) {
        return professorService.getList(professorSearch);
    }

    // 단일 정보 삭제 "/professor/auth/{id}" get
    @DeleteMapping("/api/professor/auth/{id}")
    public void delete(@PathVariable Long id) {
        professorService.delete(id);
    }

    // 비밀번호 입력 있을 시
    @PutMapping("/api/professor/auth/{id}")
    public void edit(@PathVariable Long id, @RequestBody @Valid ProfessorEdit request) {
        professorService.edit(id, request);
    }

    // 비밀번호 입력 없을 때
    @PatchMapping("/api/professor/auth/{id}")
    public void edit2(@PathVariable Long id, @RequestBody @Valid ProfessorEdit request) {
        professorService.edit2(id, request);
    }



}
