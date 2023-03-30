package com.spring.api.service;


import com.spring.api.domain.*;
import com.spring.api.exception.*;
import com.spring.api.repository.CartLectureRepository;
import com.spring.api.request.*;
import com.spring.api.response.CartLectureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartLectureService {

    private final CartLectureRepository cartLectureRepository;

    // 수강등록
    public void signup(CartLectureSignup cartLectureSignup) {

        //검증 중복 강의
        Optional<CartLecture> userOptional = cartLectureRepository.findByLectureClassAndUser(cartLectureSignup.getLectureClass(), cartLectureSignup.getUser());
        if (userOptional.isPresent()) {
            throw new AlreadyExistsCartException();
        }
        var cartLecture = CartLecture.builder()
                    .lectureClass(cartLectureSignup.getLectureClass())
                    .user(cartLectureSignup.getUser())
                    .credit(cartLectureSignup.getCredit())
                    .build();
        cartLectureRepository.save(cartLecture);
    }

    // 수강 정보 조회
    public CartLectureResponse get(Long id) {
        CartLecture cartLecture = cartLectureRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        return CartLectureResponse.builder()
                .id(cartLecture.getId())
                .lectureClass(cartLecture.getLectureClass())
                .user(cartLecture.getUser())
                .credit(cartLecture.getCredit())
                .build();

    }

    // 수강 정보 조회 리스트
    public List<CartLectureResponse> getList(CartLectureSearch cartLectureSearch) {
        return cartLectureRepository.getList(cartLectureSearch).stream()
                .map(CartLectureResponse::new)
                .collect(Collectors.toList());
    }

    // 비밀번호 있을 시 업데이트
    @Transactional
    public void edit(Long id, CartLectureEdit cartLectureEdit) {
        CartLecture cartLecture = cartLectureRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        CartLectureEditor.CartLectureEditorBuilder editorBuilder = cartLecture.toEditor();

        CartLectureEditor cartLectureEditor = editorBuilder
                .lectureClass(cartLectureEdit.getLectureClass())
                .user(cartLectureEdit.getUser())
                .build();

        cartLecture.edit(cartLectureEditor);
    }

    // 비밀번호 없을 시
    @Transactional
    public void edit2(Long id, CartLectureEdit cartLectureEdit) {
        CartLecture cartLecture = cartLectureRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        CartLectureEditor.CartLectureEditorBuilder editorBuilder = cartLecture.toEditor();

        CartLectureEditor cartLectureEditor = editorBuilder
                .lectureClass(cartLectureEdit.getLectureClass())
                .user(cartLectureEdit.getUser())
                .build();

        cartLecture.edit(cartLectureEditor);
    }

    // 삭제
    public void delete(Long id) {
        CartLecture cartLecture = cartLectureRepository.findById(id)
                .orElseThrow(UserNotFound::new);

            cartLectureRepository.delete(cartLecture);
    }

}
