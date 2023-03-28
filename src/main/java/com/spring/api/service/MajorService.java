package com.spring.api.service;

import com.spring.api.domain.Major;
import com.spring.api.domain.MajorEditor;
import com.spring.api.exception.AlreadyExistsEmailException;
import com.spring.api.exception.UserNotFound;
import com.spring.api.repository.MajorRepository;
import com.spring.api.request.*;
import com.spring.api.response.MajorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MajorService {


    private final MajorRepository majorRepository;


    // 회원가입
    public void signup(MajorSignup majorSignup) {
        Optional<Major> majorOptional = majorRepository.findByName(majorSignup.getName());
        if (majorOptional.isPresent()) {
            throw new AlreadyExistsEmailException();
        }

        var major = Major.builder()
                .name(majorSignup.getName())
                .build();
        majorRepository.save(major);
    }

    // 전공 정보 조회
    public MajorResponse get(Long id) {
        Major major = majorRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        return MajorResponse.builder()
                .id(major.getId())
                .name(major.getName())
                .build();
    }
    // 학생 정보 조회 리스트
    public List<MajorResponse> getList(MajorSearch majorSearch) {
        return majorRepository.getList(majorSearch).stream()
                .map(MajorResponse::new)
                .collect(Collectors.toList());
    }


    // 비밀번호 있을 시 업데이트
    @Transactional
    public void edit(Long id, MajorEdit majorEdit) {
        Major major = majorRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        MajorEditor.MajorEditorBuilder editorBuilder = major.toEditor();

        MajorEditor majorEditor = editorBuilder
                .name(majorEdit.getName())
                .build();

        major.edit(majorEditor);
    }

    // 비밀번호 없을 시
    @Transactional
    public void edit2(Long id, MajorEdit majorEdit) {
        Major major = majorRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        MajorEditor.MajorEditorBuilder editorBuilder = major.toEditor();

        MajorEditor majorEditor = editorBuilder
                .name(majorEdit.getName())
                .build();

        major.edit(majorEditor);
    }

    // 삭제
    public void delete(Long id) {
        Major major = majorRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        majorRepository.delete(major);
    }

}
