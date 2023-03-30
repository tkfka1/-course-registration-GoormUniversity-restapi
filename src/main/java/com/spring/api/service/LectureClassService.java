package com.spring.api.service;

import com.spring.api.domain.Lecture;
import com.spring.api.domain.LectureClass;
import com.spring.api.domain.LectureClassEditor;
import com.spring.api.domain.LectureEditor;
import com.spring.api.exception.AlreadyExistsEmailException;
import com.spring.api.exception.UserNotFound;
import com.spring.api.repository.LectureClassRepository;
import com.spring.api.request.*;
import com.spring.api.response.LectureClassResponse;
import com.spring.api.response.LectureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureClassService {

    private final LectureClassRepository lectureClassRepository;

    // 분반 생성
    public void signup(LectureClassSignup lectureClassSignup) {
        var lectureClass = LectureClass.builder()
                .lecture(lectureClassSignup.getLecture())
                .professor(lectureClassSignup.getProfessor())
                .period(lectureClassSignup.getPeriod())
                .week(lectureClassSignup.getWeek())
                .explanation(lectureClassSignup.getExplanation())
                .classMin(lectureClassSignup.getClassMin())
                .classMax(lectureClassSignup.getClassMax())
                .classPeople(lectureClassSignup.getClassPeople())
                .build();
        lectureClassRepository.save(lectureClass);
    }

    // 분반 정보 조회
    public LectureClassResponse get(Long id) {
        LectureClass lectureClass = lectureClassRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        return LectureClassResponse.builder()
                .id(lectureClass.getId())
                .lecture(lectureClass.getLecture())
                .professor(lectureClass.getProfessor())
                .period(lectureClass.getPeriod())
                .week(lectureClass.getWeek())
                .explanation(lectureClass.getExplanation())
                .classMin(lectureClass.getClassMin())
                .classMax(lectureClass.getClassMax())
                .classPeople(lectureClass.getClassPeople())
                .build();

    }

    // 분반 정보 조회 리스트
    public List<LectureClassResponse> getList(LectureClassSearch lectureClassSearch) {
        return lectureClassRepository.getList(lectureClassSearch).stream()
                .map(LectureClassResponse::new)
                .collect(Collectors.toList());
    }

    // 비밀번호 있을 시 업데이트
    @Transactional
    public void edit(Long id, LectureClassEdit lectureClassEdit) {
        LectureClass lectureClass = lectureClassRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        LectureClassEditor.LectureClassEditorBuilder editorBuilder = lectureClass.toEditor();

        LectureClassEditor lectureClassEditor = editorBuilder
                .lecture(lectureClassEdit.getLecture())
                .professor(lectureClassEdit.getProfessor())
                .period(lectureClassEdit.getPeriod())
                .week(lectureClassEdit.getWeek())
                .explanation(lectureClassEdit.getExplanation())
                .classMin(lectureClassEdit.getClassMin())
                .classMax(lectureClassEdit.getClassMax())
                .classPeople(lectureClassEdit.getClassPeople())
                .build();

        lectureClass.edit(lectureClassEditor);
    }

    // 비밀번호 없을 시
    @Transactional
    public void edit2(Long id, LectureClassEdit lectureClassEdit) {
        LectureClass lectureClass = lectureClassRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        LectureClassEditor.LectureClassEditorBuilder editorBuilder = lectureClass.toEditor();

        LectureClassEditor lectureClassEditor = editorBuilder
                .lecture(lectureClassEdit.getLecture())
                .professor(lectureClassEdit.getProfessor())
                .period(lectureClassEdit.getPeriod())
                .week(lectureClassEdit.getWeek())
                .explanation(lectureClassEdit.getExplanation())
                .classMin(lectureClassEdit.getClassMin())
                .classMax(lectureClassEdit.getClassMax())
                .classPeople(lectureClassEdit.getClassPeople())
                .build();

        lectureClass.edit(lectureClassEditor);
    }

    // 삭제
    public void delete(Long id) {
        LectureClass lectureClass = lectureClassRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        lectureClassRepository.delete(lectureClass);
    }









}
