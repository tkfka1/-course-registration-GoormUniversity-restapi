package com.spring.api.service;

import com.spring.api.crypto.PasswordEncoder;
import com.spring.api.domain.User;
import com.spring.api.domain.UserEditor;
import com.spring.api.exception.AlreadyExistsEmailException;
import com.spring.api.exception.InvalidSigninInformation;
import com.spring.api.exception.UserNotFound;
import com.spring.api.repository.UserRepository;
import com.spring.api.request.*;
import com.spring.api.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    // 로그인
    @Transactional
    public Long signin(UserLogin userLogin) {
        User user  = userRepository.findByStudentId(userLogin.getStudentId())
                .orElseThrow(InvalidSigninInformation::new);

        PasswordEncoder encoder = new PasswordEncoder();
        var matches = encoder.matches(userLogin.getPassword(), user.getPassword());
        if (!matches) {
            throw new InvalidSigninInformation();
        }

        return user.getId();
    }


    // 회원가입
    public void signup(UserSignup userSignup) {
        Optional<User> userOptional = userRepository.findByStudentId(userSignup.getStudentId());
        if (userOptional.isPresent()) {
            throw new AlreadyExistsEmailException();
        }

        PasswordEncoder encoder = new PasswordEncoder();
        String encryptedPassword = encoder.encrpyt(userSignup.getPassword());

        var user = User.builder()
                .studentId(userSignup.getStudentId())
                .email(userSignup.getEmail())
                .password(encryptedPassword)
                .name(userSignup.getName())
                .credit(userSignup.getCredit())
                .major(userSignup.getMajor())
                .haveCredit(userSignup.getHaveCredit())
                .grade(userSignup.getGrade())
                .build();
        userRepository.save(user);
    }

    // 학생 정보 조회
    public UserResponse get(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        return UserResponse.builder()
                .id(user.getId())
                .studentId(user.getStudentId())
                .email(user.getEmail())
                .name(user.getName())
                .credit(user.getCredit())
                .haveCredit(user.getHaveCredit())
                .major(user.getMajor())
                .grade(user.getGrade())
                .build();
    }
    // 학생 정보 조회 리스트
    public List<UserResponse> getList(UserSearch userSearch) {
        return userRepository.getList(userSearch).stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }


    // 비밀번호 있을 시 업데이트
    @Transactional
    public void edit(Long id, UserEdit userEdit) {
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        UserEditor.UserEditorBuilder editorBuilder = user.toEditor();

        PasswordEncoder encoder = new PasswordEncoder();
        String encryptedPassword = encoder.encrpyt(userEdit.getPassword());

        UserEditor userEditor = editorBuilder
                .name(userEdit.getName())
                .studentId(userEdit.getStudentId())
                .password(encryptedPassword)
                .credit(userEdit.getCredit())
                .haveCredit(userEdit.getHaveCredit())
                .major(userEdit.getMajor())
                .email(userEdit.getEmail())
                .grade(userEdit.getGrade())
                .build();

        user.edit(userEditor);
    }

    // 비밀번호 없을 시
    @Transactional
    public void edit2(Long id, UserEdit userEdit) {
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        UserEditor.UserEditorBuilder editorBuilder = user.toEditor();

        UserEditor userEditor = editorBuilder
                .name(userEdit.getName())
                .studentId(userEdit.getStudentId())
                .credit(userEdit.getCredit())
                .haveCredit(userEdit.getHaveCredit())
                .major(userEdit.getMajor())
                .email(userEdit.getEmail())
                .grade(userEdit.getGrade())
                .build();

        user.edit(userEditor);
    }

    // 삭제
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        userRepository.delete(user);
    }

}
