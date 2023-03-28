package com.spring.api.service;


import com.spring.api.domain.TakeLecture;
import com.spring.api.domain.TakeLectureEditor;
import com.spring.api.exception.AlreadyExistsEmailException;
import com.spring.api.exception.UserNotFound;
import com.spring.api.repository.TakeLectureRepository;
import com.spring.api.request.*;
import com.spring.api.response.TakeLectureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TakeLectureService {

    private final TakeLectureRepository takeLectureRepository;


    // 수강등록
    public void signup(TakeLectureSignup takeLectureSignup) {
//        Optional<TakeLecture> takelectureOptional = takeLectureRepository.findBy(lectureSignup.getName());
//        if (takelectureOptional.isPresent()) {
//            throw new AlreadyExistsEmailException();
//        }

        var takeLecture = TakeLecture.builder()
                    .lectureClass(takeLectureSignup.getLectureClass())
                    .user(takeLectureSignup.getUser())
                    .build();
        takeLectureRepository.save(takeLecture);
    }

    // 수강 정보 조회
    public TakeLectureResponse get(Long id) {
        TakeLecture takeLecture = takeLectureRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        return TakeLectureResponse.builder()
                .id(takeLecture.getId())
                .lectureClass(takeLecture.getLectureClass())
                .user(takeLecture.getUser())
                .build();

    }

    // 수강 정보 조회 리스트
    public List<TakeLectureResponse> getList(TakeLectureSearch takeLectureSearch) {
        return takeLectureRepository.getList(takeLectureSearch).stream()
                .map(TakeLectureResponse::new)
                .collect(Collectors.toList());
    }

    // 비밀번호 있을 시 업데이트
    @Transactional
    public void edit(Long id, TakeLectureEdit takeLectureEdit) {
            TakeLecture takeLecture = takeLectureRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        TakeLectureEditor.TakeLectureEditorBuilder editorBuilder = takeLecture.toEditor();

        TakeLectureEditor takeLectureEditor = editorBuilder
                .lectureClass(takeLectureEdit.getLectureClass())
                .user(takeLectureEdit.getUser())
                .build();

                    takeLecture.edit(takeLectureEditor);
    }

    // 비밀번호 없을 시
    @Transactional
    public void edit2(Long id, TakeLectureEdit takeLectureEdit) {
        TakeLecture takeLecture = takeLectureRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        TakeLectureEditor.TakeLectureEditorBuilder editorBuilder = takeLecture.toEditor();

        TakeLectureEditor takeLectureEditor = editorBuilder
                .lectureClass(takeLectureEdit.getLectureClass())
                .user(takeLectureEdit.getUser())
                .build();

        takeLecture.edit(takeLectureEditor);
    }

    // 삭제
    public void delete(Long id) {
            TakeLecture takeLecture = takeLectureRepository.findById(id)
                .orElseThrow(UserNotFound::new);

            takeLectureRepository.delete(takeLecture);
    }

}
