package com.spring.api.service;


import com.spring.api.domain.*;
import com.spring.api.exception.AlreadyExistsPeopleOverException;
import com.spring.api.exception.AlreadyExistsTakeException;
import com.spring.api.exception.AlreadyExistsTakeOverException;
import com.spring.api.exception.UserNotFound;
import com.spring.api.repository.LectureClassRepository;
import com.spring.api.repository.TakeLectureRepository;
import com.spring.api.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final LectureClassRepository lectureClassRepository;


    // 수강등록
    public void signup(TakeLectureSignup takeLectureSignup) {

        //검증 중복 강의
        Optional<TakeLecture> userOptional = takeLectureRepository.findByLectureClassAndUser(takeLectureSignup.getLectureClass(), takeLectureSignup.getUser());
        if (userOptional.isPresent()) {
            throw new AlreadyExistsTakeException();
        }

        User user = userRepository.findById(takeLectureSignup.getUser().getId())
                .orElseThrow(UserNotFound::new);

        LectureClass lectureClass = lectureClassRepository.findById(takeLectureSignup.getLectureClass().getId())
                .orElseThrow(UserNotFound::new);


        // 검증 학점초과
        if (user.getCredit() < user.getHaveCredit() + takeLectureSignup.getCredit()) {
            throw new AlreadyExistsTakeOverException();
        }

        // 검증 인원 초과
        if (lectureClass.getClassMax() <= lectureClass.getClassPeople()) {
            throw new AlreadyExistsPeopleOverException();
        }

        // 검증 시간 중복


        // user에 학점 추가
        UserEditor.UserEditorBuilder editorBuilder = user.toEditor();
        UserEditor userEditor = editorBuilder
                .haveCredit(user.getHaveCredit() + takeLectureSignup.getCredit())
                .build();
        user.edit(userEditor);

        // lectureClass에 인원 추가
        LectureClassEditor.LectureClassEditorBuilder lectureClassEditorBuilder = lectureClass.toEditor();
        LectureClassEditor lectureClassEditor = lectureClassEditorBuilder
                .classPeople(lectureClass.getClassPeople() + 1)
                .build();
        lectureClass.edit(lectureClassEditor);

        // takeLecture에 추가
        var takeLecture = TakeLecture.builder()
                    .lectureClass(takeLectureSignup.getLectureClass())
                    .user(takeLectureSignup.getUser())
                    .credit(takeLectureSignup.getCredit())
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
                .credit(takeLecture.getCredit())
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

            // User 학점 삭제
            User user = userRepository.findById(takeLecture.getUser().getId())
                .orElseThrow(UserNotFound::new);

            UserEditor.UserEditorBuilder editorBuilder = user.toEditor();
            UserEditor userEditor = editorBuilder
                    .haveCredit(user.getHaveCredit() - takeLecture.getCredit())
                    .build();
            user.edit(userEditor);

            // LectureClass 인원 삭제
            LectureClass lectureClass = lectureClassRepository.findById(takeLecture.getLectureClass().getId())
                .orElseThrow(UserNotFound::new);

            LectureClassEditor.LectureClassEditorBuilder lectureClassEditorBuilder = lectureClass.toEditor();
            LectureClassEditor lectureClassEditor = lectureClassEditorBuilder
                    .classPeople(lectureClass.getClassPeople() - 1)
                    .build();
            lectureClass.edit(lectureClassEditor);

            takeLectureRepository.delete(takeLecture);
    }

}
