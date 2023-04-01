package com.spring.api.controller;


import com.spring.api.request.*;
import com.spring.api.response.CartLectureResponse;
import com.spring.api.response.TakeLectureResponse;
import com.spring.api.service.CartLectureService;
import com.spring.api.service.TakeLectureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CartLectureController {

    // 수강 crud 컨트롤러

    private final CartLectureService cartLectureService;

    // 수강 장바구니 등록  "/cart/auth/signup" post
    @PostMapping("/api/cart/auth/signup")
    public void signup(@RequestBody CartLectureSignup cartLectureSignup) {
        cartLectureService.signup(cartLectureSignup);
    }


    // 단일 장바구니 조회 "/cart/auth/{id}" get
    @GetMapping("/api/cart/auth/{id}")
    public CartLectureResponse get(@PathVariable Long id) {
        return cartLectureService.get(id);
    }

    // 전체 장바구니 조회 "/cart/auth/{id}" get
    @GetMapping("/api/cart/auth")
    public List<CartLectureResponse> getList(@ModelAttribute CartLectureSearch cartLectureSearch) {
        return cartLectureService.getList(cartLectureSearch);
    }

    // 단일 장바구니 삭제 "/cart/auth/{id}" get
    @DeleteMapping("/api/cart/auth/{id}")
    public void delete(@PathVariable Long id) {
        cartLectureService.delete(id);
    }

    // 비밀번호 입력 있을 시
    @PutMapping("/api/cart/auth/{id}")
    public void edit(@PathVariable Long id, @RequestBody @Valid CartLectureEdit request) {
        cartLectureService.edit(id, request);
    }

    // 비밀번호 입력 없을 때
    @PatchMapping("/api/cart/auth/{id}")
    public void edit2(@PathVariable Long id, @RequestBody @Valid CartLectureEdit request) {
        cartLectureService.edit2(id, request);
    }


}
