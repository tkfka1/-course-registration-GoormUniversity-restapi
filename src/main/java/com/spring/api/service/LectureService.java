package com.spring.api.service;

import com.spring.api.domain.Lecture;
import com.spring.api.domain.LectureEditor;
import com.spring.api.exception.AlreadyExistsEmailException;
import com.spring.api.exception.UserNotFound;
import com.spring.api.repository.LectureRepository;
import com.spring.api.request.*;
import com.spring.api.response.LectureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;


    // 회원가입
    public void signup(LectureSignup lectureSignup) {
        Optional<Lecture> lectureOptional = lectureRepository.findByName(lectureSignup.getName());
        if (lectureOptional.isPresent()) {
            throw new AlreadyExistsEmailException();
        }

        var lecture = Lecture.builder()
                .name(lectureSignup.getName())
                .major(lectureSignup.getMajor())
                .credit(lectureSignup.getCredit())
                .build();
        lectureRepository.save(lecture);
    }

    // 학생 정보 조회
    public LectureResponse get(Long id) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        return LectureResponse.builder()
                .id(lecture.getId())
                .name(lecture.getName())
                .major(lecture.getMajor())
                .credit(lecture.getCredit())
                .build();

    }

    // 학생 정보 조회 리스트
    public List<LectureResponse> getList(LectureSearch lectureSearch) {
        return lectureRepository.getList(lectureSearch).stream()
                .map(LectureResponse::new)
                .collect(Collectors.toList());
    }

    // 비밀번호 있을 시 업데이트
    @Transactional
    public void edit(Long id, LectureEdit lectureEdit) {
            Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(UserNotFound::new);

            LectureEditor.LectureEditorBuilder editorBuilder = lecture.toEditor();

            LectureEditor lectureEditor = editorBuilder
                .name(lectureEdit.getName())
                .major(lectureEdit.getMajor())
                .credit(lectureEdit.getCredit())
                .build();

                    lecture.edit(lectureEditor);
    }

    // 비밀번호 없을 시
    @Transactional
    public void edit2(Long id, LectureEdit lectureEdit) {
            Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(UserNotFound::new);

            LectureEditor.LectureEditorBuilder editorBuilder = lecture.toEditor();

            LectureEditor lectureEditor = editorBuilder
                .name(lectureEdit.getName())
                .major(lectureEdit.getMajor())
                .credit(lectureEdit.getCredit())
                .build();

            lecture.edit(lectureEditor);
    }

    // 삭제
    public void delete(Long id) {
            Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(UserNotFound::new);

            lectureRepository.delete(lecture);
    }

}
